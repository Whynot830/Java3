package com.example.pw11;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Validated
public class SimpleController {
    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return new ResponseEntity<>("<h1>Hello World</h1>", HttpStatus.OK);
    }
}
