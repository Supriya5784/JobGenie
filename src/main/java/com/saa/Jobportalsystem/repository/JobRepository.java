package com.saa.Jobportalsystem.repository;

import com.saa.Jobportalsystem.model.Job;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JobRepository extends MongoRepository<Job, String> {
}