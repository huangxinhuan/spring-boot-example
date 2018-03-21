package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;


public interface UserJpaRepository extends JpaRepository<User, Integer> {

//    @Query(value = "SELECT `id`,`name` FROM users WHERE `name` LIKE :name", nativeQuery = true)
//    List<User> findByName(@Param("name") String name);

    List<User> findByName(String name);

}
