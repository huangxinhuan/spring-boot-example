package com.example.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

@ConfigurationProperties(prefix = "my")
public class MyBean {

    private List<Integer> randNums = new ArrayList<>();

    private String uuid;

    private String name;


    public String getUuid(){
        return uuid;
    }


    public List<Integer> getNums(){
        return randNums;
    }


    public String getName(){
        return name;
    }

}
