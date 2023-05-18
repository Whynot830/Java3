package com.example.pw24.Services;

import com.example.pw24.Repos.DepartureRepo;
import com.example.pw24.Tables.Departure;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class DepartureService implements TableService<Departure> {
    private DepartureRepo departureRepo;

    public DepartureService(DepartureRepo departureRepo) {
        this.departureRepo = departureRepo;
    }
    @Transactional
    @Override
    public void createEntity(Departure departure) {
        log.info("Create departure {}", departure);
        departureRepo.save(departure);
    }
    @Transactional(readOnly = true)
    @Override
    public List<Departure> readAllEntity() {
        log.info("Read all departures");
        return departureRepo.findAll();
    }
    @Transactional(readOnly = true)
    @Override
    public Optional<Departure> readOneEntity(Long id) {
        log.info("Read one departure, id: {}", id);
        return departureRepo.findById(id);
    }
    @Transactional
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
    @Transactional
    @Override
    public boolean deleteEntity(Long id) {
        log.info("Delete departure, id: {}", id);
        if (departureRepo.findById(id).isEmpty())
            return false;
        departureRepo.deleteById(id);
        return true;
    }
    @Transactional(readOnly = true)
    public List<Departure> readSortedByType() {
        log.info("Read all departures, sorted by type");
        return departureRepo.findAll(Sort.by("departureType"));
    }
    @Transactional(readOnly = true)
    public List<Departure> filterByDepartureType(String departureType) {
        log.info("Filter departures by type: {}", departureType);
        return departureRepo.findAllByDepartureType(departureType);
    }
}
