package com.example.pw23.Controllers;

import com.example.pw23.Services.PostOfficeService;
import com.example.pw23.Tables.Departure;
import com.example.pw23.Tables.PostOffice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/post_offices")
public class PostOfficeController {
    private final PostOfficeService tableService;

    @Autowired
    public PostOfficeController(PostOfficeService tableService) {
        this.tableService = tableService;
    }

    @PostMapping(consumes = {"application/json"})
    public ResponseEntity<Void> createDeparture(@RequestBody PostOffice postOffice) {
        tableService.createEntity(postOffice);
        return ResponseEntity.created(null).build();
    }

    @GetMapping
    public ResponseEntity<List<PostOffice>> read() {
        final List<PostOffice> postOffices = tableService.readAllEntity();
        if (!postOffices.isEmpty())
            return ResponseEntity.ok(postOffices);
        return ResponseEntity.notFound().build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PostOffice> read(@PathVariable("id") Long id) {
        Optional<PostOffice> postOffice = tableService.readOneEntity(id);
        return postOffice.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody PostOffice postOffice) {
        if (tableService.updateEntity(postOffice, id))
            return ResponseEntity.ok().build();
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        if (tableService.deleteEntity(id))
            return ResponseEntity.ok().build();
        return ResponseEntity.notFound().build();
    }
    @GetMapping(value = "/cityname/{cityName}")
    public ResponseEntity<List<PostOffice>> getAllPostOfficesByCityName(@PathVariable("cityName") String cityName) {
        return ResponseEntity.ok(tableService.filterByCityName(cityName));
    }
    @GetMapping(value = "/sorted")
    public ResponseEntity<List<PostOffice>> getSortedPostOffices() {
        return ResponseEntity.ok(tableService.readSortedByCityName());
    }
    @GetMapping(value = "/{id}/departures")
    public ResponseEntity<List<Departure>> getAllDepartureSByPostOffice(@PathVariable("id") Long id) {
        Optional<PostOffice> postOffice = tableService.readOneEntity(id);
        return postOffice.map(office -> ResponseEntity.ok(office.getDepartures())).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
