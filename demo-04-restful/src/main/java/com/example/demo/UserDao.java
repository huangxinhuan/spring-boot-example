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
        User user = null;
        try {
            user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class),id);
        }catch (Exception e){
            user = new User();
        }
        return user;
    }

    public int deleteById(Integer id){
        String sql = "DELETE FROM `users` WHERE `id`=?";
        return jdbcTemplate.update(sql, ps -> {
            ps.setInt(1,id);
        });

    }

    public int add(User user){
        String sql = "INSERT INTO `users`(`id`,`name`) VALUES(?,?)";

        try {
            return jdbcTemplate.update(sql, ps -> {
                ps.setInt(1, user.getId());
                ps.setString(2, user.getName());
            });
        }catch (Exception e){
            return -1;
        }

    }

    public int update(User user){
        String sql = "UPDATE `users` SET `name` = ? WHERE `id` = ?";
       return jdbcTemplate.update(sql, ps -> {
            ps.setString(1,user.getName());
            ps.setInt(2,user.getId());
        });
    }

}
