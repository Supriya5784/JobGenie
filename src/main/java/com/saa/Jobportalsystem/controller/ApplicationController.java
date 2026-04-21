package com.saa.Jobportalsystem.controller;

import com.saa.Jobportalsystem.model.Application;
import com.saa.Jobportalsystem.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
@CrossOrigin("*")
public class ApplicationController {

    @Autowired
    private ApplicationRepository repo;

    @PostMapping
    public Application apply(@RequestBody Application app) {
        return repo.save(app);
    }

    @GetMapping("/{email}")
    public List<Application> getUserApps(@PathVariable String email) {
        return repo.findByUserEmail(email);
    }
}