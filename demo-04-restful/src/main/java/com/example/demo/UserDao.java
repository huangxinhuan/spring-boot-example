package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public User findById(Integer id) {

        String sql = "SELECT `id`,`name` FROM `users` WHERE `id` = ?";
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class),id);
        return user;
    }

    public void deleteById(Integer id){
        String sql = "DELETE FROM `users` WHERE `id`=" + id;
        jdbcTemplate.execute(sql);
    }

    public void add(User user){
        String sql = "INSERT INTO `users`(`id`,`name`) VALUES(?,?)";

        jdbcTemplate.update(sql, ps -> {
            ps.setInt(1,user.getId());
            ps.setString(2,user.getName());
        });

    }

    public void update(User user){
        String sql = "UPDATE `users` SET `name` = ? WHERE `id` = ?";
        jdbcTemplate.update(sql, ps -> {
            ps.setString(1,user.getName());
            ps.setInt(2,user.getId());
        });
    }

}
