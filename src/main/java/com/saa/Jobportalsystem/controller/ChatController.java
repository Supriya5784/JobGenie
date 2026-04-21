package com.saa.Jobportalsystem.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/chat")
@CrossOrigin("*")
public class ChatController {

    @PostMapping
    public Map<String, String> chat(@RequestBody Map<String, Object> request) {

        String message = (String) request.get("message");

        String reply;

        if (message.toLowerCase().contains("job")) {
            reply = "I can help you find jobs based on your skills!";
        } else if (message.toLowerCase().contains("resume")) {
            reply = "Try adding measurable achievements in your resume.";
        } else {
            reply = "I'm your JobGenie assistant ✨ Ask me anything!";
        }

        Map<String, String> response = new HashMap<>();
        response.put("reply", reply);

        return response;
    }
}