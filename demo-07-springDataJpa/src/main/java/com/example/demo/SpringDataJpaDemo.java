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
    public CommandLineRunner demo(UserRepository repository) {
        return (args) -> {
            // save a couple of Userrs
            repository.save(new User("Jack"));
            repository.save(new User("Chloe"));
            repository.save(new User("Kim"));
            repository.save(new User("David"));
            repository.save(new User("Michelle"));

            // fetch all Users
            log.info("Users found with findAll():");
            log.info("-------------------------------");
            for (User User : repository.findAll()) {
                log.info(User.toString());
            }
            log.info("");

            // fetch an individual User by ID
            User User = repository.findOne(1);
            log.info("User found with findOne(1L):");
            log.info("--------------------------------");
            log.info(User.toString());
            log.info("");

        };
    }

}
