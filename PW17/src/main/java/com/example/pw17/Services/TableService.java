package com.example.pw17.Services;

import java.util.List;

public interface TableService<T> {

    void createEntity(T t);
    List<T> readAllEntity();
    T readOneEntity(Integer id);
    boolean updateEntity(T t, Integer id);
    boolean deleteEntity(Integer id);
}
