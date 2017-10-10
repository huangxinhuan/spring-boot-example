package com.example.demo;


import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.JVM)
public class UserRepositoryTest {

    @Autowired
    UserCrudRepository repo;

//    @Autowired
//    UserJpaRepository repo;

    @Test
    public void testFindAll() throws Exception{
        System.out.println("----------testFindAll()---------");
        repo.findAll().forEach(System.out::println);
    }

    @Test
    public void testFindOne() throws Exception{
        System.out.println("----------testFindOne()---------");
        User user = repo.findOne(1);
        System.out.println(user);
    }

    @Test
    public void testFindAll2() throws Exception{
        System.out.println("----------testFindAll2()---------");
        repo.findAll(Arrays.asList(1,2,3,999)).forEach(System.out::println);
    }

    @Test
    public void testDeleteOne() throws Exception{
        System.out.println("----------testDeleteOne()---------");
        repo.delete(1);
        Assert.assertFalse(repo.exists(1));
    }

    @Test
    public void testDeleteAll() throws Exception{
        System.out.println("----------testDeleteAll()---------");
        repo.deleteAll();
        Assert.assertEquals(0,repo.count());
    }

    @Test
    public void testFindByName() throws Exception{
        System.out.println("----------testFindByName()---------");

        repo.findByName("Jack").stream().forEach(System.out::println);

    }

}
