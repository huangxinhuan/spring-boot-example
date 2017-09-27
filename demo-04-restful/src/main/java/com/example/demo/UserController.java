package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {


    @Autowired
    private UserDao userDao;

    @RequestMapping("/user/{id}")
    @ResponseBody
    public String findUserById(@PathVariable("id") Integer id) {
       return userDao.findById(id).toString();
    }

}
