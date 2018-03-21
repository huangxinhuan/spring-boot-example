package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDataJpaDemo {

    private static final Logger log = LoggerFactory.getLogger(SpringDataJpaDemo.class);

    public static void main(String[] args){
        SpringApplication.run(SpringDataJpaDemo.class,args);
    }

    @Bean
    public CommandLineRunner demo(UserCrudRepository repository) {
        return (args) -> {
            // save a couple of Users
//            repository.save(new User("Chloe"));
//            repository.save(new User("Kim"));
//            repository.save(new User("David"));
//            repository.save(new User("Michelle"));
//            log.info("add users from CommandLineRunner.");
        };
    }

}
