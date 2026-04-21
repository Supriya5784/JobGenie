package com.saa.Jobportalsystem.service;

import com.saa.Jobportalsystem.model.Job;
import com.saa.Jobportalsystem.repository.JobRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    private final JobRepository repo;

    public JobService(JobRepository repo) {
        this.repo = repo;
    }

    public Job createJob(Job job) {
        return repo.save(job);
    }

    public List<Job> getAllJobs() {
        return repo.findAll();
    }
}