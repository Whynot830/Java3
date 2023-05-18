package com.example.pw24.Controllers;

import com.example.pw24.Services.UserAppService;
import com.example.pw24.Tables.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
