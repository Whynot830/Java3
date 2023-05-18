package com.example.pw18.Services;

import com.example.pw18.Repos.DepartureRepo;
import com.example.pw18.Tables.Departure;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartureService implements TableService<Departure> {
    private DepartureRepo departureRepo;

    @Autowired
    DepartureService(DepartureRepo departureRepo) {
        this.departureRepo = departureRepo;
    }

    @Override
    public void createEntity(Departure departure) {
        departureRepo.save(departure);
    }

    @Override
    public List<Departure> readAllEntity() {
        return departureRepo.findAll();
    }

    @Override
    public Optional<Departure> readOneEntity(Long id) {
        return departureRepo.findById(id);
    }

    @Override
    public boolean updateEntity(Departure departure, Long id) {
        Optional<Departure> optionalDeparture = departureRepo.findById(id);
        if (optionalDeparture.isPresent()) {
            departure.setId(optionalDeparture.get().getId());
            departureRepo.save(departure);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteEntity(Long id) {
        if (departureRepo.findById(id).isEmpty())
            return false;
        departureRepo.deleteById(id);
        return true;
    }

    public List<Departure> filterByDepartureType(String departureType) {
        return departureRepo.findAllByDepartureType(departureType);
    }

    public List<Departure> readSortedByType() {
        return departureRepo.findAll(Sort.by("departureType"));
    }

}
