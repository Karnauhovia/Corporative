package com.real.project.controller;


import com.google.gson.Gson;
import com.real.project.entity.Course;
import com.real.project.entity.Person;
import com.real.project.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;


@Controller
@RequestMapping(value = "/person/course/")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @RequestMapping(value = "/get/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Double getCourse() {

        Double d = courseRepository.GetCourse();
         return BigDecimal.valueOf(d).setScale(2, BigDecimal.ROUND_HALF_DOWN).doubleValue();
  //             return courseRepository.GetCourse();

    }

    @RequestMapping(value ="/set/", method= RequestMethod.POST)
    @ResponseBody
    public void setCourse(@RequestBody String course) {
        Gson gson = new Gson();
        Course courseObj = gson.fromJson(course, Course.class);

        courseRepository.saveAndFlush(courseObj);

    }
}
