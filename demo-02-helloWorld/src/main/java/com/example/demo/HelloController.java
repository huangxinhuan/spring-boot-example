package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@RestController
public class HelloController {

    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("/")
    public String index(HttpServletRequest request){
        log.info("Service request from {}:{} at {}.",request.getRemoteHost(),request.getRemotePort(), LocalDateTime.now());
        return "Hello World from Spring Boot @" + LocalDateTime.now();
    }

}
