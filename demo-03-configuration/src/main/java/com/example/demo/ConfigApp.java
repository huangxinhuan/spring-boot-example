package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;


@SpringBootApplication
public class ConfigApp {

    public static void main(String[] args){
        SpringApplication.run(ConfigApp.class,args);
    }

}
