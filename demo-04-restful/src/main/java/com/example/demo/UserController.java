package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {


    @Autowired
    private UserDao userDao;

    @RequestMapping(path = "/user/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String findUserById(@PathVariable("id") Integer id) {
        User user = userDao.findById(id);
        return user.toString();
    }

    @RequestMapping(path = "/user/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteUserById(@PathVariable("id") Integer id) {
        int rows = userDao.deleteById(id);
        return String.valueOf(rows);
    }

    @RequestMapping(path = "/user/{id}/{name}", method = RequestMethod.POST)
    @ResponseBody
    public String addUser(@PathVariable("id") Integer id, @PathVariable("name") String name) {
        int rows = userDao.add(newUserInstance(id, name));
        return String.valueOf(rows);
    }

    @RequestMapping(path = "/user/{id}/{name}", method = RequestMethod.PUT)
    @ResponseBody
    public String updateUser(@PathVariable("id") Integer id, @PathVariable("name") String name) {
        int rows = userDao.update(newUserInstance(id, name));
        return String.valueOf(rows);
    }

    private User newUserInstance(Integer id, String name) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        return user;
    }


}
