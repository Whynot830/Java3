package com.example.pw19.Repos;

import com.example.pw19.Tables.Departure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartureRepo extends JpaRepository<Departure, Long> {
    List<Departure> findAllByDepartureType(String departureType);
}
