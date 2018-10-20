package com.example.demo;


import com.example.demo.converter.UserConverter;
import com.example.demo.dto.UserDto;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.UserExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserConverter userConverter;

    @RequestMapping("/users")
    @ResponseBody
    public List<UserDto> getAllUsers(@RequestBody String body){
        System.out.println("body:" + body);
        List<UserDto> users = userMapper.selectByExample(new UserExample())
                .stream()
                .map(userConverter::toUserDto)
                .collect(Collectors.toList());
        log.info("##### users:{}", users);
        return users;
    }
}
