package com.ciphersentinel.server.controller;

import com.ciphersentinel.server.model.User;
import com.ciphersentinel.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController
{
    @Autowired
    private UserRepository userRepository;
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam(value = "username") String username,
                        @RequestParam(value = "password") String password)
    {
        // Find user by username and password
        User user = userRepository.findByUsernameAndPassword(username, password);

        // Check if user exists
        if (user != null)
        {
            return ResponseEntity.ok("Login successful");
        }
        else
        {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed");
        }

    }
}
