package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@EnableConfigurationProperties(MyBean.class)
public class MyConfig {

    @Autowired
    private MyBean myBean;

    @Bean("uuid")
    public String getUuid(){
        return myBean.getUuid();
    }

    @Bean("name")
    public String getName(){
        return myBean.getName();
    }

    @Bean("nums")
    public List<Integer> getNums(){
        return myBean.getNums();
    }


}
