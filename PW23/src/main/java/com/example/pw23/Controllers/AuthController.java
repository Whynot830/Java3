package com.example.pw23.Controllers;

import com.example.pw23.Services.UserAppService;
import com.example.pw23.Tables.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class AuthController {
    private final UserAppService userAppService;
    public AuthController(UserAppService userAppService) {
        this.userAppService = userAppService;
    }
    @GetMapping("/login")
    public String getLoginView() {
        return "login";
    }
    @GetMapping("/register")
    public String getRegistrationView() {
        return "registration";
    }
    @PostMapping("/register")
    public String register(@ModelAttribute(value = "user") User user) {
        return userAppService.addUser(user);
    }
}
