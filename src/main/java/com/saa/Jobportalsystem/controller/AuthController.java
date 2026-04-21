package com.saa.Jobportalsystem.controller;

import com.saa.Jobportalsystem.model.User;
import com.saa.Jobportalsystem.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        return service.register(user);
    }
    @PostMapping("/login")
    public String login(@RequestBody(required = false) User user) {
        if (user == null) return "Body missing";
        return service.login(user.getEmail(), user.getPassword());
    }
}