package com.example.demo;

import com.example.demo.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    public UserRepository repo;

    @Test
    public void testFindOne() throws Exception{
        User user = repo.findOne(1);
        System.out.println(user);
    }

    @Test
    public void testFindAll() throws Exception{
        repo.findAll().stream().forEach(System.out::println);
    }

    @Test
    public void testDeleteOne() throws Exception{
        Integer row =repo.deleteOne(9999);
        Assert.assertEquals(Integer.valueOf(0),row);
    }

    @Test
    public void testAdd() throws Exception{
        User user = new User();
        user.setId(9);
        user.setName("xxx");
        Integer rows  = repo.add(user);
        Assert.assertEquals(Integer.valueOf(1),rows);
    }

    @Test
    public void testUpdate() throws Exception{
        User user = new User();
        user.setId(1);
        user.setName("xyz");
        Integer rows  = repo.update(user);
        Assert.assertEquals(Integer.valueOf(1),rows);

    }

}
