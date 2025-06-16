package com.gradusapi.apirest.controller;

import org.springframework.http.ResponseEntity; // Importar ResponseEntity
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/status") 
public class StatusController { 

    @GetMapping
    public ResponseEntity<String> checkStatus() {
        // ResponseEntity.ok() já retorna o status HTTP 200 OK
        return ResponseEntity.ok("API está online e funcionando!");
    }
}