package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DynamicTaskController {

    private String cron5 = "0/5 * * * * ?";

    private String cron2 = "0/2 * * * * ?";



    @Autowired
    DynamicScheduledTask task;



    @RequestMapping("/replace")
    public String change(){
        task.setCron(cron5);
        return cron5;
    }

    @RequestMapping("/start")
    public String start(){
        task.start();
        return "OK";
    }

}
