package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class HelloWorldApp {

    private static final Logger log = LoggerFactory.getLogger(HelloWorldApp.class);

    public static void main(String[] args){
        SpringApplication.run(HelloWorldApp.class,args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx){
        // return a function
        return args -> {
            log.info("Let's inspect the beans provided by Spring Boot:");
            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.asList(beanNames).forEach(b -> log.info("{}@{}",b,String.valueOf(b.hashCode())));
        };

    }
}
