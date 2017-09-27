package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConfigPropsTest {

    @Autowired
    private MailProperties configProps;

    @Test
    public void testConfigProps(){
        assertEquals("demo.example.com",configProps.getHost());
        assertEquals(Integer.valueOf(9000), configProps.getPort());
        assertEquals("user@demo.example.com", configProps.getFrom());
        assertEquals(Arrays.asList("admim@demo.example.com","owner@demo.example.com"),configProps.getRecipients());
        assertEquals("username", configProps.getCredential().getUsername());
        assertEquals("password01", configProps.getCredential().getPassword());
        assertEquals(Arrays.asList("SHA1","MD5"),configProps.getCredential().getAuthMethod());
    }


}
