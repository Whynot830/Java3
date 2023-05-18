package com.example.pw14.PostOffice;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("post_offices")
public class PostOfficeController {
    private static Long id;
    private HashMap<Long, PostOffice> postOffices;
    public PostOfficeController() {
        id = 1L;
        postOffices = new HashMap<>();
    }
    @PostMapping
    public PostOffice save(@RequestBody PostOffice postOffice) {
        postOffices.put(id++, postOffice);
        return postOffice;
    }
    @DeleteMapping void delete(@RequestParam Long id) {
        postOffices.remove(id);
    }
    @GetMapping
    public HashMap<Long, PostOffice> getAllPostOffices() {
        return postOffices;
    }

}
