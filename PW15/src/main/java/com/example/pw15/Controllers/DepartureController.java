package com.example.pw15.Controllers;

import com.example.pw15.Services.TableService;
import com.example.pw15.Tables.Departure;
import jakarta.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departures")
public class DepartureController {
    private final TableService<Departure> tableService;

    @Autowired
    public DepartureController(TableService<Departure> tableService) {
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
}
