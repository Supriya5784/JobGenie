package com.saa.Jobportalsystem.repository;

import com.saa.Jobportalsystem.model.Application;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ApplicationRepository extends MongoRepository<Application, String> {
    List<Application> findByUserEmail(String email);
}
