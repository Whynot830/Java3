package com.example.pw18.Repos;

import com.example.pw18.Tables.PostOffice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostOfficeRepo extends JpaRepository<PostOffice, Long> {
    List<PostOffice> findAllByCityName(String cityName);
}
