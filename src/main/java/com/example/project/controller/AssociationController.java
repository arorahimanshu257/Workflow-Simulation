package com.example.project.controller;

import com.example.project.dto.AssociationRequest;
import com.example.project.dto.AssociationResponse;
import com.example.project.service.AssociationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/associations")
public class AssociationController {
    private final AssociationService associationService;

    @Autowired
    public AssociationController(AssociationService associationService) {
        this.associationService = associationService;
    }

    @PostMapping
    public ResponseEntity<AssociationResponse> associateReleaseToMilestone(@Valid @RequestBody AssociationRequest request) {
        AssociationResponse response = associationService.associateReleaseToMilestone(request);
        return ResponseEntity.ok(response);
    }
}
