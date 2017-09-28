package com.example.demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JdbcTemplateTest {
    @Autowired
    private JdbcTemplate template;

    @Test
    public void testTemplate() throws Exception{
        Assert.assertNotNull(template);
        final Set<String> tables = new HashSet<>();
        template.query("SHOW TABLES", rowCallback -> {
            String table = rowCallback.getString(1);
            tables.add(table.toUpperCase());
        });
        Set<String> expected = new HashSet<>(Arrays.asList("ACCOUNTS","USERS"));
        Assert.assertEquals(tables,expected);

    }

    @Test
    public void testGrouping() throws Exception{
        String sql = "SELECT `name`, SUM(`amount`) FROM `users`,`accounts` WHERE `users`.`id`=`accounts`.`uid` GROUP BY `users`.`id`";
        System.out.println(String.format("%8s | %8s","name","sum"));
        template.query(sql, row -> {
            System.out.println(String.format("%8s | %8.2f",row.getString(1),row.getDouble(2)));
        });

    }
}
