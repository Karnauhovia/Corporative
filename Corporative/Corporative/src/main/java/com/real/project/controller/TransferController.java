package com.real.project.controller;

import com.google.gson.Gson;
import com.real.project.entity.Person;
import com.real.project.entity.Transfers;
import com.real.project.repository.PersonRepository;
import com.real.project.repository.TransfersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping(value = "/transfers")
public class TransferController {


    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private TransfersRepository transfersRepository;



    @RequestMapping(value = "/put/",method = RequestMethod.POST)
    @ResponseBody
    public void addTransfer(@RequestBody String transfer) {
        Gson gson = new Gson();
        Person personobj = gson.fromJson(transfer, Person.class);
        Transfers transfers = gson.fromJson(transfer, Transfers.class);

        Person personById = personRepository.findOne(transfers.getCash_id());
        transfers.setCash_another(personById.getAnother());
        transfers.setCash_bonus(personById.getBonus());
        transfers.setCash_dinners(personById.getDinners());
        transfers.setCash_overtimes(personById.getOvertimes());
        transfers.setCash_taxes(personById.getTaxes());
        transfers.setCash_salary(personById.getRate());
        transfers.setCash_count(personById.getCount());

        Date today = new Date();
        String todayDay = DateFormat.getDateInstance().format(today);
        transfers.setPay_date(todayDay);

        personById.setCount(personobj.getCount());
        transfers.setPerson(personById);

        transfersRepository.saveAndFlush(transfers);

    }

    @RequestMapping(value = "/",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<Transfers> getAllPersonsHql(){

        return transfersRepository.findAll();


    }


}
