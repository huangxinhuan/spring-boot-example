package com.example.demo;

import com.example.demo.domain.Account;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
//@ActiveProfiles("dev")
public class AccountRepositoryTest {

    @Autowired
    private AccountRepository repo;

    @Test
    public void testFindOne() throws Exception{
        Account account = repo.findOne(1);
        System.out.println(account);
    }

    @Test
    public void testFindAll() throws Exception{
        repo.findAll().stream().forEach(System.out::println);
    }

    @Test
    public void testDeleteOne() throws Exception{
        Integer row =repo.deleteOne(1);
        //Assert.assertEquals(Integer.valueOf(1),row);
    }

    @Test
    public void testAdd() throws Exception{
        Account account = new Account();
        account.setUid(2);
        account.setAmount(124.33);
        Integer rows  = repo.add(account);
        Assert.assertEquals(Integer.valueOf(1),rows);
    }

    @Test
    public void testUpdate() throws Exception{
        Account account = new Account();
        account.setId(2);
        account.setUid(1);
        account.setAmount(99999.99);
        Integer rows  = repo.update(account);
        Assert.assertEquals(Integer.valueOf(1),rows);

    }
}
