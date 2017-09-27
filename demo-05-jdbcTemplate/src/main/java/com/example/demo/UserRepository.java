package com.example.demo;

import com.example.demo.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository extends BaseRepository implements GenericDao<Integer, User> {

    @Override
    public User findOne(Integer key) {
        String sql = "SELECT `id`,`name` FROM `users` WHERE `id`=?";
        User user = new User();
        jdbcTemplate.query(sql, preparedStatement -> {
            preparedStatement.setInt(1, key);
        }, rowCallback -> {
            if (rowCallback.isFirst()) {
                user.setId(rowCallback.getInt("id"));
                user.setName(rowCallback.getString("name"));
            }
        });
        return user;
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        jdbcTemplate.query("SELECT `id`,`name` FROM `users`", row -> {
            User user = new User();
            user.setId(row.getInt(1));
            user.setName(row.getString(2));
            users.add(user);
        });
        return users;
    }

    @Override
    public Integer deleteOne(Integer key) {
        String sql = "DELETE FROM `users` WHERE `id`=?";
        return jdbcTemplate.update(sql, pss -> {
            pss.setInt(1, key);
        });
    }

    @Override
    public Integer update(User user) {
        String sql = "UPDATE `users` SET `name`=? WHERE `id`=?";
        return jdbcTemplate.update(sql, ps -> {
            ps.setString(1, user.getName());
            ps.setInt(2, user.getId());
        });
    }

    @Override
    public Integer add(User user) {
        String sql = "INSERT INTO `users`(`id`,`name`) VALUES(?,?)";
        Integer rows = 0;
        try {
            rows = jdbcTemplate.update(sql, ps -> {
                ps.setInt(1, user.getId());
                ps.setString(2, user.getName());
            });
        }catch (Exception e){
            rows = -1;
        }
        return Integer.valueOf(rows);
    }
}
