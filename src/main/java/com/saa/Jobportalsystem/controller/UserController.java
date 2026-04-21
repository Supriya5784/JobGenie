package com.saa.Jobportalsystem.controller;

import com.saa.Jobportalsystem.model.User;
import com.saa.Jobportalsystem.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("*")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // ✅ GET USER PROFILE
    @GetMapping("/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
    @GetMapping("/me")
    public User getCurrentUser(org.springframework.security.core.Authentication authentication) {
        String email = authentication.getName(); // JWT se aayega
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
    @PutMapping("/{email}")
    public User updateUser(@PathVariable String email, @RequestBody User updatedUser) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // update fields
        user.setName(updatedUser.getName());
        user.setEmail(updatedUser.getEmail());
        user.setPhone(updatedUser.getPhone());
        user.setLocation(updatedUser.getLocation());
        user.setBio(updatedUser.getBio());
        user.setSkills(updatedUser.getSkills());
        user.setInterests(updatedUser.getInterests());

        return userRepository.save(user);
    }
}