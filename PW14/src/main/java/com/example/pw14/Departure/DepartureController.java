package com.example.pw14.Departure;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("departures")
public class DepartureController {
    private static Long id;
    private HashMap<Long, Departure> departures;
    public DepartureController() {
        id = 1L;
        departures = new HashMap<>();
    }
    @PostMapping
    public Departure save(@RequestBody Departure departure) {
        departures.put(id++, departure);
        return departure;
    }
    @DeleteMapping
    public void delete(@RequestParam Long id) {
        departures.remove(id);
    }
    @GetMapping
    public HashMap<Long, Departure> getAllDepartures() {
        return departures;
    }
}
