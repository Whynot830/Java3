package com.example.pw21.Repos;

import com.example.pw21.Tables.PostOffice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostOfficeRepo extends JpaRepository<PostOffice, Long> {
    List<PostOffice> findAllByCityName(String cityName);
}
