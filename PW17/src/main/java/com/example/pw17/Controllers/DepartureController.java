package com.example.pw17.Controllers;

import com.example.pw17.Services.DepartureService;
import com.example.pw17.Services.TableService;
import com.example.pw17.Tables.Departure;
import com.example.pw17.Tables.PostOffice;
import jakarta.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departures")
public class DepartureController {
    private final DepartureService tableService;

    @Autowired
    public DepartureController(DepartureService tableService) {
        this.tableService = tableService;
    }

    @PostMapping(consumes = {"application/json"})
    public ResponseEntity<Void> createDeparture(@RequestBody Departure departure) {
        tableService.createEntity(departure);
        return ResponseEntity.created(null).build();
    }

    @GetMapping
    public ResponseEntity<List<Departure>> read() {
        final List<Departure> departures = tableService.readAllEntity();
        if (!departures.isEmpty())
            return ResponseEntity.ok(departures);
        return ResponseEntity.notFound().build();

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Departure> read(@PathVariable("id") Integer id) {
        try {
            final Departure departure = tableService.readOneEntity(id);
            return ResponseEntity.ok(departure);
        } catch (NoResultException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody Departure departure) {
        if (tableService.updateEntity(departure, id))
            return ResponseEntity.ok().build();
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        if (tableService.deleteEntity(id))
            return ResponseEntity.ok().build();
        return ResponseEntity.notFound().build();
    }

    @GetMapping(value = "/{id}/postoffice")
    public ResponseEntity<PostOffice> getPostOfficeByDeparture(@PathVariable("id") Integer id) {
        final PostOffice postOffice = tableService.readOneEntity(id).getPostOffice();
        System.out.println(postOffice);
        return ResponseEntity.ok(postOffice);
    }
    @GetMapping(value = "/type/{departureType}")
    public ResponseEntity<List<Departure>> getAllDeparturesByType(@PathVariable("departureType") String departureType) {
        final List<Departure> departures = tableService.filterByDepartureType(departureType);
        return ResponseEntity.ok(departures);
    }
    @GetMapping(value = "/sorted")
    public ResponseEntity<List<Departure>> getSortedDepartures() {
        final List<Departure> departures = tableService.readSortedByType();
        return ResponseEntity.ok(departures);
    }
}
