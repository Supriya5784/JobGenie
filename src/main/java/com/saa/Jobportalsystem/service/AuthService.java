package com.saa.Jobportalsystem.service;

import com.saa.Jobportalsystem.model.User;
import com.saa.Jobportalsystem.repository.UserRepository;
import com.saa.Jobportalsystem.security.JwtUtil;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository repo;
    private final JwtUtil jwtUtil;

    public AuthService(UserRepository repo, JwtUtil jwtUtil) {
        this.repo = repo;
        this.jwtUtil = jwtUtil;
    }

    public String register(User user) {
        repo.save(user);
        return "User registered";
    }

    public String login(String email, String password) {
        User user = repo.findByEmail(email).orElseThrow();

        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid password");
        }

        return jwtUtil.generateToken(email);
    }
}