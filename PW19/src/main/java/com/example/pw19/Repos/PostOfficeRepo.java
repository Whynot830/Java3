package com.example.pw19.Repos;

import com.example.pw19.Tables.PostOffice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostOfficeRepo extends JpaRepository<PostOffice, Long> {
    List<PostOffice> findAllByCityName(String cityName);
}
