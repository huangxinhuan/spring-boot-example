package com.example.demo;

import javax.persistence.*;

@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name", columnDefinition = "CHAR(32)")
    private String name;


    public User(){}

    public User(String name){
        this.name = name;
    }

    public User(Integer id, String name){
        this.id = id;
        this.name = name;
    }

    // getter & setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("{\"id\":%d,\"name\":\"%s\"}", id, name);
    }
}
