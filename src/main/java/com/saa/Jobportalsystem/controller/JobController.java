package com.saa.Jobportalsystem.controller;

import com.saa.Jobportalsystem.model.Job;
import com.saa.Jobportalsystem.service.JobService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
@CrossOrigin("*") // frontend connect ke liye
public class JobController {

    private final JobService service;

    public JobController(JobService service) {
        this.service = service;
    }

    @PostMapping
    public Job createJob(@RequestBody Job job) {
        return service.createJob(job);
    }

    @GetMapping
    public List<Job> getAllJobs() {
        return service.getAllJobs();
    }
    @PostMapping("/api/resume/upload")
    public String uploadResume(@RequestParam("file") MultipartFile file,
                               @RequestParam("email") String email) {
        // save file logic (later enhance)
        return "Uploaded";
    }
}