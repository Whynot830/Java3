package com.example.pw23.Services;

import java.util.List;
import java.util.Optional;

public interface TableService<T> {

    void createEntity(T t);
    List<T> readAllEntity();
    Optional<T> readOneEntity(Long id);
    boolean updateEntity(T t, Long id);
    boolean deleteEntity(Long id);
}
