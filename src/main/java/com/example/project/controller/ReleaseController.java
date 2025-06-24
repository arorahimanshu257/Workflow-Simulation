package com.example.project.controller;

import com.example.project.dto.ReleaseCreateRequest;
import com.example.project.dto.ReleaseResponse;
import com.example.project.service.ReleaseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/releases")
public class ReleaseController {
    private final ReleaseService releaseService;

    @Autowired
    public ReleaseController(ReleaseService releaseService) {
        this.releaseService = releaseService;
    }

    @PostMapping
    public ResponseEntity<ReleaseResponse> createRelease(@Valid @RequestBody ReleaseCreateRequest request) {
        ReleaseResponse response = releaseService.createRelease(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReleaseResponse> getReleaseById(@PathVariable String id) {
        ReleaseResponse response = releaseService.getReleaseById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/project/{projectId}")
    public ResponseEntity<List<ReleaseResponse>> getReleasesByProject(@PathVariable String projectId) {
        List<ReleaseResponse> response = releaseService.getReleasesByProject(projectId);
        return ResponseEntity.ok(response);
    }
}
