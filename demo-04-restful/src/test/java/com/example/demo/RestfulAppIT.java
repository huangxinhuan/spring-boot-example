package com.example.demo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URI;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestfulAppIT {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate template;

    private String url;

    @Before
    public void init() {
        url = "http://localhost:" + port + "/user";
    }

    @Test
    public void testFindUser() throws Exception {
        String resp = template.getForEntity(url + "/1", String.class)
                .getBody();
        Assert.assertNotNull(resp);
        System.out.println(resp);
    }

    @Test
    public void testDeleteUser() throws Exception{
        template.delete(url + "/1");
    }

    @Test
    public void testAddUser() throws Exception{
       String resp = template.postForEntity(new URI(url + "/100/xxx"),
               null,String.class).getBody();
       Assert.assertEquals("1",resp);
    }

    @Test
    public void testUpdateUser() throws Exception{
        template.put(url + "/100/xxx", null);
    }


}
