package com.example.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.startsWith;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloWorldAppIT { // integration testing
    @LocalServerPort
    private int port;

    private String base;

    @Autowired
    private TestRestTemplate template;

    @Before
    public void setUp() throws Exception{
        base = "http://localhost:" + port + "/";
    }

    @Test
    public void testHelloWorld() throws Exception{
        ResponseEntity<String> responseEntity = template.getForEntity(base,String.class);
        assertThat(responseEntity.getBody(),startsWith("Hello World from Spring Boot"));
    }

}
