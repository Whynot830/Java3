package com.example.pw17.Controllers;

import com.example.pw17.Services.PostOfficeService;
import com.example.pw17.Services.TableService;
import com.example.pw17.Tables.Departure;
import com.example.pw17.Tables.PostOffice;
import jakarta.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<PostOffice> read(@PathVariable("id") Integer id) {
        try {
            final PostOffice postOffice = tableService.readOneEntity(id);
            return ResponseEntity.ok(postOffice);
        } catch (NoResultException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody PostOffice postOffice) {
        if (tableService.updateEntity(postOffice, id))
            return ResponseEntity.ok().build();
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        if (tableService.deleteEntity(id))
            return ResponseEntity.ok().build();
        return ResponseEntity.notFound().build();
    }
    @GetMapping(value = "/cityname/{cityName}")
    public ResponseEntity<List<PostOffice>> getAllPostOfficesByCityName(@PathVariable("cityName") String cityName) {
        final List<PostOffice> postOffices = tableService.filterByCityName(cityName);
        return ResponseEntity.ok(postOffices);
    }
}
