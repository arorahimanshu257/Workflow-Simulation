package com.example.project.service;

import com.example.project.dto.MilestoneCreateRequest;
import com.example.project.dto.MilestoneResponse;
import com.example.project.entity.Milestone;
import com.example.project.exception.DuplicateMilestoneTitleException;
import com.example.project.exception.InvalidMilestoneDateRangeException;
import com.example.project.exception.MilestoneNotFoundException;
import com.example.project.repository.MilestoneRepository;
import com.example.project.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MilestoneService {
    private final MilestoneRepository milestoneRepository;

    @Autowired
    public MilestoneService(MilestoneRepository milestoneRepository) {
        this.milestoneRepository = milestoneRepository;
    }

    @Transactional
    public MilestoneResponse createMilestone(MilestoneCreateRequest request) {
        // Check for unique title within project
        Optional<Milestone> existing = milestoneRepository.findByProjectIdAndTitle(request.getProjectId(), request.getTitle());
        if (existing.isPresent()) {
            throw new DuplicateMilestoneTitleException("Milestone title must be unique within the project.");
        }
        // Validate date range
        if (!ValidationUtil.isMilestoneDateRangeValid(request.getStartDate(), request.getEndDate())) {
            throw new InvalidMilestoneDateRangeException("Milestone end date must be after or equal to start date.");
        }
        Milestone milestone = new Milestone();
        milestone.setProjectId(request.getProjectId());
        milestone.setTitle(request.getTitle());
        milestone.setDescription(request.getDescription());
        milestone.setStartDate(request.getStartDate());
        milestone.setEndDate(request.getEndDate());
        milestone.setState("CREATED");
        milestone.setReleaseIds(new java.util.ArrayList<>());
        Milestone saved = milestoneRepository.save(milestone);
        return toResponse(saved);
    }

    public MilestoneResponse getMilestoneById(String id) {
        Milestone milestone = milestoneRepository.findById(id)
                .orElseThrow(() -> new MilestoneNotFoundException("Milestone not found: " + id));
        return toResponse(milestone);
    }

    public List<MilestoneResponse> getMilestonesByProject(String projectId) {
        return milestoneRepository.findByProjectId(projectId)
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    private MilestoneResponse toResponse(Milestone milestone) {
        return new MilestoneResponse(
                milestone.getId(),
                milestone.getProjectId(),
                milestone.getTitle(),
                milestone.getDescription(),
                milestone.getStartDate(),
                milestone.getEndDate(),
                milestone.getState(),
                milestone.getReleaseIds()
        );
    }
}
