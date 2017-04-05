package com.real.project.controller;


import com.google.gson.Gson;
import com.real.project.entity.Course;
import com.real.project.entity.Person;
import com.real.project.entity.Transfers;
import com.real.project.implementation.PersonImpl;
import com.real.project.repository.CourseRepository;
import com.real.project.repository.PersonRepository;
import com.real.project.repository.TransfersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/person")
public class PersonController {

    @Autowired
    private TransfersRepository transfersRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private CourseRepository courseRepository;


    @RequestMapping(value ="/put/", method= RequestMethod.POST)
    @ResponseBody
       public void addPerson(@RequestBody String person) {
        Gson gson = new Gson();
        Person personObj = gson.fromJson(person, Person.class);

        personObj.setCash_back_uah(personObj.getAnother()+personObj.getDinners() +personObj.getTaxes());
        personObj.setCash_back_usd(personObj.getOvertimes()+personObj.getBonus());

        personRepository.saveAndFlush(personObj);

    }


    @RequestMapping(value = "/update/", method = RequestMethod.POST)
    @ResponseBody
    public void updatePerson(@RequestBody String person) {
        Gson gson = new Gson();
        Person personObj = gson.fromJson(person, Person.class);

        personObj.setCash_back_uah(personObj.getAnother()+personObj.getDinners() +personObj.getTaxes());
        personObj.setCash_back_usd(personObj.getOvertimes()+personObj.getBonus());

        personRepository.saveAndFlush(personObj);

    }

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<Person> getAllPersons() {
        int ParamShows = 0;
          return personRepository.findAllpers(ParamShows);

//        try {
//            return personDao.getAllByHQL();
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return null;
//        }


    }

    @RequestMapping(value = "/debtors", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<Person> getDebtorsPersons() {

        return personRepository.findDebtpers();

    }

    @RequestMapping(value = "/deleted", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<Person> getAllDeletedPersons() {
        int ParamShows = 1;
        return personRepository.findAllpers(ParamShows);

    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public void deletePerson(@PathVariable("id") Long id) {
        Person personById = personRepository.findOne(id);
        personById.setShows(1);
        personRepository.saveAndFlush(personById);
    }

    @RequestMapping(value = "/undelete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public void UndeletePerson(@PathVariable("id") Long id) {
        Person personById = personRepository.findOne(id);
        personById.setShows(0);
        personRepository.saveAndFlush(personById);
    }


    @RequestMapping(value = "/input/{filePath}", method = RequestMethod.GET)
    @ResponseBody
    public void readXLSFile(@PathVariable("filePath") String filePath) throws IOException {

        String file = filePath.toString();
        //String file2 = file.replace("C:\\fakepath","C:\\Users\\Igor\\Downloads");
        String file2 = "C:\\Users\\Igor\\Downloads\\"+file;


        String parserObj = Parser.parse(file2);

        List<Transfers> listT = superParser(parserObj);

        for(int i=0;i<listT.size();i++) {

            Gson gson = new Gson();
            //Person personobj = gson.fromJson(String.valueOf(listT.get(i)), Person.class);
            Transfers transfers = gson.fromJson(String.valueOf(listT.get(i)), Transfers.class);

            Person personById = personRepository.findOne(transfers.getCash_id());
            transfers.setCash_another(personById.getAnother());
            transfers.setCash_bonus(personById.getBonus());
            transfers.setCash_dinners(personById.getDinners());
            transfers.setCash_overtimes(personById.getOvertimes());
            transfers.setCash_taxes(personById.getTaxes());
            transfers.setCash_salary(personById.getRate());
            
            personById.setCount(listT.get(i).getCash_balance());
            transfers.setPerson(personById);

            transfersRepository.saveAndFlush(transfers);

        }

    }

    @RequestMapping(value = "/inputDebt/{filePath}", method = RequestMethod.GET)
    @ResponseBody
    public void readXLSXDebtFile(@PathVariable("filePath") String filePath) throws IOException {

        String file = filePath.toString();
        //String file2 = file.replace("C:\\fakepath","C:\\Users\\Igor\\Downloads");
        String file2 = "C:\\Users\\Igor\\Downloads\\"+file;


        String parserObj = Parser.parse(file2);

        List<Transfers> listT = superParserForDebt(parserObj);

        for(int i=0;i<listT.size();i++) {

            Gson gson = new Gson();
            //Person personobj = gson.fromJson(String.valueOf(listT.get(i)), Person.class);
            Transfers transfers = gson.fromJson(String.valueOf(listT.get(i)), Transfers.class);

            Person personById = personRepository.findOne(transfers.getCash_id());
//            transfers.setCash_another(personById.getAnother());
//            transfers.setCash_bonus(personById.getBonus());
//            transfers.setCash_dinners(personById.getDinners());
//            transfers.setCash_overtimes(personById.getOvertimes());
//            transfers.setCash_taxes(personById.getTaxes());
//            transfers.setCash_salary(personById.getRate());

            personById.setCount(listT.get(i).getCash_balance());
            transfers.setPerson(personById);

            transfersRepository.saveAndFlush(transfers);

        }

    }

    private List<Transfers> superParserForDebt(String parserObj) {
        String Obj = parserObj.replaceAll("UAH", "").replaceAll("USD", "").replaceAll("\\.00", "");

        String[] arrLine = Obj.split(" \n");
        List<Transfers> list = new ArrayList<>();

        for (int i = 1; i < arrLine.length; i++) {

            String[] PersonArr = arrLine[i].trim().replaceAll("[\\s]{2,}", " ").replaceAll(",","").split(" ");

            Transfers transfers = new Transfers();
            Person person = new Person();

            Long id = Long.parseLong(PersonArr[0].replaceAll("\\.0", ""));

            Float cours = Float.parseFloat(PersonArr[PersonArr.length-2]);
            Float pay = Float.parseFloat(PersonArr[PersonArr.length-1])/cours;


            //float rate = Float.parseFloat(PersonArr[PersonArr.length-1])/cours;

            Date today = new Date();
            String todayDay = DateFormat.getDateInstance().format(today);

            person.setId(id);
            //float c = Float.parseFloat(PersonArr[PersonArr.length-4])-(Float.parseFloat(PersonArr[PersonArr.length-1])/cours);
            Float count = Float.parseFloat(PersonArr[PersonArr.length-3]);
            if (count<0.02){count= Float.valueOf(0);}
            person.setCount(count);

            float balance = count-pay;

            if (balance<0.02){balance=0;}

            //float c = Float.parseFloat(PersonArr[PersonArr.length-4])-(Float.parseFloat(PersonArr[PersonArr.length-1])/cours);
            //person.setCount((float) (Math.round(c * Math.pow(10, 2)) / Math.pow(10, 2)));

            transfers.setCash_pay(pay);
            transfers.setPay_date(todayDay);
            transfers.setCash_id(id);
            transfers.setCash_course(cours);
            transfers.setCash_count(count);
            transfers.setCash_balance(balance);

            transfers.setPerson(person);
            list.add(transfers);

        }

        return list;

    }

    private static List<Transfers> superParser(String parserObj) {

        String Obj = parserObj.replaceAll("UAH", "").replaceAll("USD", "").replaceAll("\\.00", "");
//        String Obj = parserObj.replaceAll("UAH", "").replaceAll("USD", "");
//        String Obj2 = Obj.replaceAll("\\.0", "");
        String[] arrLine = Obj.split(" \n");
        List<Transfers> list = new ArrayList<>();

        for (int i = 1; i < arrLine.length; i++) {

            String[] PersonArr = arrLine[i].trim().replaceAll("[\\s]{2,}", " ").replaceAll(",","").split(" ");

            Transfers transfers = new Transfers();
            Person person = new Person();

            Long id = Long.parseLong(PersonArr[0].replaceAll("\\.0", ""));

            float cours = Float.parseFloat(PersonArr[PersonArr.length-2])/Float.parseFloat(PersonArr[PersonArr.length-4]);
            float rate = Float.parseFloat(PersonArr[PersonArr.length-1])/cours;


            Date today = new Date();
            String todayDay = DateFormat.getDateInstance().format(today);

            person.setId(id);

            float c = Float.parseFloat(PersonArr[PersonArr.length-3])-rate;
            float rest = (float) (Math.round(c * Math.pow(10, 2)) / Math.pow(10, 2));
            if(rest<0.02){rest=0;}
            person.setCount(rest);

            //person.setCount(Float.parseFloat(PersonArr[PersonArr.length-4])-(Float.parseFloat(PersonArr[PersonArr.length-1])/cours));

            transfers.setCash_pay(rate);
            transfers.setPay_date(todayDay);
            transfers.setCash_id(id);
            transfers.setCash_course(cours);
            transfers.setCash_balance(rest);
            transfers.setPerson(person);

            list.add(transfers);


        }

        return list;

    }


}
