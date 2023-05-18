package com.example.pw20.Services;

import com.example.pw20.Repos.DepartureRepo;
import com.example.pw20.Tables.Departure;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class DepartureService implements TableService<Departure> {
    private DepartureRepo departureRepo;

    @Autowired
    DepartureService(DepartureRepo departureRepo) {
        this.departureRepo = departureRepo;
    }

    @Override
    public void createEntity(Departure departure) {
        log.info("Create departure {}", departure);
        departureRepo.save(departure);
    }

    @Override
    public List<Departure> readAllEntity() {
        log.info("Read all departures");
        return departureRepo.findAll();
    }

    @Override
    public Optional<Departure> readOneEntity(Long id) {
        log.info("Read one departure, id: {}", id);
        return departureRepo.findById(id);
    }

    @Override
    public boolean updateEntity(Departure departure, Long id) {
        log.info("Update departure, id: {}, new departure: {}", id, departure);
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
        log.info("Delete departure, id: {}", id);
        if (departureRepo.findById(id).isEmpty())
            return false;
        departureRepo.deleteById(id);
        return true;
    }

    public List<Departure> readSortedByType() {
        log.info("Read all departures, sorted by type");
        return departureRepo.findAll(Sort.by("departureType"));
    }

    public List<Departure> filterByDepartureType(String departureType) {
        log.info("Filter departures by type: {}", departureType);
        return departureRepo.findAllByDepartureType(departureType);
    }
}
