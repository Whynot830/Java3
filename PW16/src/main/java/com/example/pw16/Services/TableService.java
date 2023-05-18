package com.example.pw16.Services;

import com.example.pw16.Tables.Departure;
import com.example.pw16.Tables.PostOffice;

import java.util.List;

public interface TableService<T> {

    void createEntity(T t);
    List<T> readAllEntity();
    T readOneEntity(Integer id);
    boolean updateEntity(T t, Integer id);
    boolean deleteEntity(Integer id);
}
