package com.example.demo;

import java.util.List;

public interface GenericDao<K,T> {

    T findOne(K key);

    List<T> findAll();

    Integer deleteOne(K key);

    Integer update(T t);

    Integer add(T t);
}
