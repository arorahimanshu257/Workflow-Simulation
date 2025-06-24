package com.example.project.controller;

import com.example.project.dto.MilestoneCreateRequest;
import com.example.project.dto.MilestoneResponse;
import com.example.project.service.MilestoneService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/milestones")
public class MilestoneController {
    private final MilestoneService milestoneService;

    @Autowired
    public MilestoneController(MilestoneService milestoneService) {
        this.milestoneService = milestoneService;
    }

    @PostMapping
    public ResponseEntity<MilestoneResponse> createMilestone(@Valid @RequestBody MilestoneCreateRequest request) {
        MilestoneResponse response = milestoneService.createMilestone(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MilestoneResponse> getMilestoneById(@PathVariable String id) {
        MilestoneResponse response = milestoneService.getMilestoneById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/project/{projectId}")
    public ResponseEntity<List<MilestoneResponse>> getMilestonesByProject(@PathVariable String projectId) {
        List<MilestoneResponse> response = milestoneService.getMilestonesByProject(projectId);
        return ResponseEntity.ok(response);
    }
}
