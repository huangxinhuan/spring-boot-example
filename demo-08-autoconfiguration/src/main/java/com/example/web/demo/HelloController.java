package com.example.web.demo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {


    @ResponseBody
    @GetMapping("/")
    public Map<String, Object> hello(){
        return new HashMap<String, Object>(){{
            put("message", "hello world");
            put("ip", getHostIpAddress());
        }};
    }

    @ResponseBody
    @GetMapping("/exception")
    public Object exception(){
        return new Exception("error");
    }

    @ResponseBody
    @GetMapping("/te")
    public Object te() throws Exception{
        if(System.currentTimeMillis() % 2 == 0) {
            throw new Exception("error");
        }
        return null;
    }

    private String getHostIpAddress(){
        try {
            return InetAddress.getLocalHost().getHostAddress();
        }catch (Exception e){
            return "unknown";
        }
    }



}
