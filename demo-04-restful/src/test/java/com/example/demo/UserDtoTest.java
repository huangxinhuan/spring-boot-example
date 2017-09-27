package com.example.demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDtoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void testFindById() throws Exception{
        User user = userDao.findById(1);
        Assert.assertEquals(Integer.valueOf(1),user.getId());
        Assert.assertEquals("user01",user.getName());
    }

    @Test
    public void testDeleteById() throws Exception{
        userDao.deleteById(1);
        // check no existed
        User user = userDao.findById(1);
        Assert.assertEquals(null,user.getId());
        Assert.assertEquals(null,user.getName());
    }

    @Test
    public void testAdd() throws Exception{
        User user = new User();
        user.setId(100);
        user.setName("xxx");
        userDao.add(user);
        // check added
        User u = userDao.findById(100);
        Assert.assertEquals(user.getId(),u.getId());
        Assert.assertEquals(user.getName(),u.getName());
    }

    @Test
    public void testUpdate() throws Exception{
        User user = new User();
        user.setId(2);
        user.setName("USER02");
        userDao.update(user);
        // check updated
        User u = userDao.findById(2);
        Assert.assertEquals(user.getId(),u.getId());
        Assert.assertEquals(user.getName(),u.getName());
    }
}
