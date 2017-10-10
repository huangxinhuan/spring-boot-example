package com.example.demo;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserCrudRepository extends CrudRepository<User,Integer>{

    List<User> findByName(String name);
}

