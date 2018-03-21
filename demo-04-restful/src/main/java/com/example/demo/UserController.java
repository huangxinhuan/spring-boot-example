package com.example.demo;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@RestController
public class UserController {


    @Autowired
    private UserDao userDao;

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    private static final Cache<String, Object> CACHE;

    static {
        CACHE = CacheBuilder.newBuilder()
                .maximumSize(2)
                .recordStats()
                .build();
    }

    @RequestMapping(path = "/cache")
    public List<User> getCache(){
       return CACHE.asMap().entrySet().stream().map(e -> (User)e.getValue()).collect(Collectors.toList());
    }

    @RequestMapping(path = "/user/{id}", method = RequestMethod.GET)
    public User findUserById(@PathVariable("id") Integer id) {


        User user = null;

        try {
            user = (User) CACHE.get(id.toString(), new Callable<Object>() {
                @Override
                public Object call() throws Exception {
                    return 1/0;
                }
            });

        } catch (Exception e) {
            log.info("exec error : ", e);
            user = newUserInstance(id,"default");
        }

        //

        return user;
    }

    @RequestMapping(path = "/user/{id}", method = RequestMethod.DELETE)
    public String deleteUserById(@PathVariable("id") Integer id) {
        int rows = userDao.deleteById(id);
        return String.valueOf(rows);
    }

    @RequestMapping(path = "/user/{id}/{name}", method = RequestMethod.POST)
    public String addUser(@PathVariable("id") Integer id, @PathVariable("name") String name) {
        int rows = userDao.add(newUserInstance(id, name));
        return String.valueOf(rows);
    }

    @RequestMapping(path = "/user/{id}/{name}", method = RequestMethod.PUT)
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
