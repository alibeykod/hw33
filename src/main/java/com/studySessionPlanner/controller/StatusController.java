package com.studySessionPlanner.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status")
public class StatusController {
    @GetMapping
    public ResponseEntity<String> getStatus(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("X-Planner-Version", "1.0")
                .body("Study Planner Is Running ");
    }
}
