package com.example.pw22.Controllers;

import com.example.pw22.Services.DepartureService;
import com.example.pw22.Tables.Departure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


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
        return ResponseEntity.ok(tableService.readAllEntity());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Departure> read(@PathVariable("id") Long id) {
        Optional<Departure> departure = tableService.readOneEntity(id);
        return departure.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Departure departure) {
        if (tableService.updateEntity(departure, id))
            return ResponseEntity.ok().build();
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        if (tableService.deleteEntity(id))
            return ResponseEntity.ok().build();
        return ResponseEntity.notFound().build();
    }

//    @GetMapping(value = "/type/{departureType}")
//    public ResponseEntity<List<Departure>> getAllDeparturesByType(@PathVariable("departureType") String departureType) {
//        return ResponseEntity.ok(tableService.filterByDepartureType(departureType));
//    }
//    @GetMapping(value = "/sorted")
//    public ResponseEntity<List<Departure>> getSortedDepartures() {
//        return ResponseEntity.ok(tableService.readSortedByType());
//    }
}
