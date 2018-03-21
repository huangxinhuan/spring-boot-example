package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserJpaRepository userRepository;

    @RequestMapping(path = "/user/id/{id}", method = RequestMethod.GET)
    public User findUserById(@PathVariable("id") Integer id) {
        User user = userRepository.findOne(id);
        return user;
    }

    @RequestMapping(path = "/user/id/{id}", method = RequestMethod.DELETE)
    public String deleteUserById(@PathVariable("id") Integer id) {
        userRepository.delete(id);
        return "success";
    }

    @RequestMapping(path = "/user/id/{id}/name/{name}", method = RequestMethod.POST)
    public String addUser(@PathVariable("id") Integer id, @PathVariable("name") String name) {
        User user = newUserInstance(id, name);
        userRepository.save(user);
        return user.toString();
    }

    @RequestMapping(path = "/user/name/{name}", method = RequestMethod.POST)
    public String addUser(@PathVariable("name") String name) {
        User user = new User();
        user.setName(name);
        userRepository.save(user);
        return user.toString();
    }

    @RequestMapping(path = "/user/id/{id}/name/{name}", method = RequestMethod.PUT)
    public String updateUser(@PathVariable("id") Integer id, @PathVariable("name") String name) {
        userRepository.save(newUserInstance(id, name));
        return "success";
    }
    @RequestMapping(path = "/user", method = RequestMethod.GET)
    public String getAllUsers(){
        List<User> users = userRepository.findAll();
        String buf = String.join(",",users.stream().map(u -> u.toString()).collect(Collectors.toList()));
        return '[' + buf + ']';
    }

    private User newUserInstance(Integer id, String name) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        return user;
    }


}
