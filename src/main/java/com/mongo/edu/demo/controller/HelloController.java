package com.mongo.edu.demo.controller;

import com.mongo.edu.demo.model.Demo;
import com.mongo.edu.demo.repository.DemoRepository;
import com.mongo.edu.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("hello")
public class HelloController {

    @Autowired
    private DemoRepository demoRepository;
    @Autowired
    private DemoService demoService;

    @RequestMapping("")
    @ResponseBody
    public String hello() {

        return "Hello Spring boot";
    }

    @RequestMapping("/mongo")
    @ResponseBody
    public String mongo() throws Exception {
        Demo demo = demoRepository.findByName("demo");

        demoService.saveMongo();

        return demo.getName() + demo.getLocation();
    }



}
