package com.example.demo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

@Component
public class DynamicScheduledTask implements SchedulingConfigurer, Runnable {

    private static final Logger log = LoggerFactory.getLogger(DynamicScheduledTask.class);


    @Value("0/2 * * * * ?")
    private String cron;

    private ScheduledTaskRegistrar registry;

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        this.registry = scheduledTaskRegistrar;
        Trigger trigger = triggerContext -> {
            //log.info("Calculating next time...");
            CronTrigger cronTrigger = new CronTrigger(cron);
            return cronTrigger.nextExecutionTime(triggerContext);
        };
        log.info("start task...");
        registry.addTriggerTask(this,trigger);
    }

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }

    public void start(){
        Trigger trigger = triggerContext -> {
            //log.info("Calculating next time...");
            CronTrigger cronTrigger = new CronTrigger(cron);
            return cronTrigger.nextExecutionTime(triggerContext);
        };
        log.info("start task...");
        registry.addTriggerTask(this,trigger);
    }

    @Override
    public void run() {
        log.info("Executing Task...");
    }
}
