package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ScheduledTask {

    private static final Logger log = LoggerFactory.getLogger(TaskSchedulingApp.class);
    /**
     * Executing task every 2 sec.
     */
    @Scheduled(cron = "0/2 * * * * ?")
    public void taskOne(){
        log.info("Executing Task One @ " + LocalDateTime.now());
    }


    /**
     * Executing task once per sec, where the second of time is in [0-10].
     */
    @Scheduled(cron = "0-10/1 * * * * MON-FRI")
    public void taskTwo(){
        log.info("Executing Task Two @ " + LocalDateTime.now());
    }

    /**
     * Executing task once per sec, where the seconds of time is 0.
     */
    @Scheduled(cron = "0 * * * * *")
    public void taskThree(){
        log.info("Executing Task Three @ " + LocalDateTime.now());
    }
}
