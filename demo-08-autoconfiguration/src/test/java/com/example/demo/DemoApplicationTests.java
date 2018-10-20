package com.example.demo;

import com.example.demo.converter.UserConverter;
import com.example.demo.dto.Gender;
import com.example.demo.dto.UserDto;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.model.UserExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	UserMapper userMapper;


	@Autowired
	UserConverter userConverter;


	@Test
	public void contextLoads() {
		System.out.println(Gender.MALE);
	}

	@Test
	public void text0() {
		UserExample example = new UserExample();
		example.createCriteria()
				.andIdGreaterThan(2L);
		example.or().andIdEqualTo(1l);


		List<User> users = userMapper.selectByExample(example);

		users.forEach(System.out::println);

		List<UserDto> userDtos = users.stream().map(userConverter::toUserDto).collect(Collectors.toList());
		//int ans = userDao.insertInBatch(users);

		System.out.println("--------------------------------------- ");
	}

}
