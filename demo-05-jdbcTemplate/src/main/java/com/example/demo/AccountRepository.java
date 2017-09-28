package com.example.demo;

import com.example.demo.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountRepository implements GenericDao<Integer, Account> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Account findOne(Integer key) {
        String sql = "SELECT `id`,`uid`,`amount` FROM `accounts` WHERE `id`=?";

        try {
            List<Account> accounts = jdbcTemplate.query(sql, new Object[]{key}, new BeanPropertyRowMapper<Account>(Account.class));
            return accounts.get(0);
        } catch (Exception e) {
            return new Account();
        }

    }

    @Override
    public List<Account> findAll() {
        String sql = "SELECT `id`,`uid`,`amount` FROM `accounts`";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Account>(Account.class));
    }

    @Override
    public Integer deleteOne(Integer key) {
        String sql = "DELETE FROM `accounts` WHERE `id`=?";
        return jdbcTemplate.update(sql,new Object[]{key});
    }

    @Override
    public Integer update(Account account) {
        String sql = "UPDATE `accounts` SET `uid`=?, `amount`=? WHERE `id`=?";
        return jdbcTemplate.update(sql, account.getUid(),account.getAmount(),account.getId());
    }

    @Override
    public Integer add(Account account) {
        String sql = "INSERT INTO `accounts`(`id`,`uid`,`amount`) VALUES(?,?,?)";
        try{
            return jdbcTemplate.update(sql,account.getId(),account.getUid(),account.getAmount());
        }catch (Exception e){
            return Integer.valueOf(-1);
        }
    }
}
