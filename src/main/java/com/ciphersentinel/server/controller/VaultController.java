package com.ciphersentinel.server.controller;

import com.ciphersentinel.server.model.Credential;
import com.ciphersentinel.server.repository.VaultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class VaultController
{
    @Autowired
    private VaultRepository vaultRepository;
    @GetMapping("/vault")
    public ResponseEntity<String> getVault(@RequestParam(value = "userId") int userId)
    {
        // Get vault by user id
        List<Credential> vault = vaultRepository.findByUserId(userId);

        // Construct a HashMap of username-password pairs
        Map<String, String> vaultMap = new HashMap<>();

        for (Credential credential : vault)
        {
            vaultMap.put(credential.getUsername(), credential.getPassword());
        }

        // Convert HashMap to JSON
        ObjectMapper objectMapper = new ObjectMapper();

        try
        {
            String json = objectMapper.writeValueAsString(vaultMap);
            return ResponseEntity.ok(json);
        }
        catch (JsonProcessingException e)
        {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error converting credential HashMap to JSON.");
        }
    }
}
