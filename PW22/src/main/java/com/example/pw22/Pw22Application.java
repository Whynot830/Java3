package com.example.pw22;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Pw22Application {

    public static void main(String[] args) {
        SpringApplication.run(Pw22Application.class, args);
    }

}
