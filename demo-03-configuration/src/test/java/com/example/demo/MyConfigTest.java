package com.example.demo;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyConfigTest {



    @Autowired
    @Qualifier("uuid")
    private String uuid;

    @Autowired
    @Qualifier("name")
    private String name;

    @Test
    public void testMyConfig(){
        Assert.assertNotNull(uuid);
        System.out.println("uuid : " + uuid + "@" + uuid.hashCode());
        Assert.assertNotNull(name);
        System.out.println("name : " + name + "@" + name.hashCode());
        //Assert.assertNotNull(num);
    }


}
