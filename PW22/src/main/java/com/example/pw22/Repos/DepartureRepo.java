package com.example.pw22.Repos;

import com.example.pw22.Tables.Departure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartureRepo extends JpaRepository<Departure, Long> {
    List<Departure> findAllByDepartureType(String departureType);
}
