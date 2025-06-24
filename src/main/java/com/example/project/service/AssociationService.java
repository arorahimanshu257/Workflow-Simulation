package com.example.project.service;

import com.example.project.dto.AssociationRequest;
import com.example.project.dto.AssociationResponse;
import com.example.project.entity.Milestone;
import com.example.project.entity.Release;
import com.example.project.exception.MilestoneNotFoundException;
import com.example.project.exception.ReleaseAlreadyAssociatedException;
import com.example.project.exception.ReleaseNotFoundException;
import com.example.project.repository.MilestoneRepository;
import com.example.project.repository.ReleaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AssociationService {
    private final MilestoneRepository milestoneRepository;
    private final ReleaseRepository releaseRepository;

    @Autowired
    public AssociationService(MilestoneRepository milestoneRepository, ReleaseRepository releaseRepository) {
        this.milestoneRepository = milestoneRepository;
        this.releaseRepository = releaseRepository;
    }

    @Transactional
    public AssociationResponse associateReleaseToMilestone(AssociationRequest request) {
        Milestone milestone = milestoneRepository.findById(request.getMilestoneId())
                .orElseThrow(() -> new MilestoneNotFoundException("Milestone not found: " + request.getMilestoneId()));
        Release release = releaseRepository.findById(request.getReleaseId())
                .orElseThrow(() -> new ReleaseNotFoundException("Release not found: " + request.getReleaseId()));
        // Ensure release is not already associated with another milestone
        if (release.getMilestoneId() != null && !release.getMilestoneId().isEmpty()) {
            throw new ReleaseAlreadyAssociatedException("Release already associated with a milestone.");
        }
        // Associate
        release.setMilestoneId(milestone.getId());
        releaseRepository.save(release);
        // Add releaseId to milestone's releaseIds list if not already present
        if (!milestone.getReleaseIds().contains(release.getId())) {
            milestone.getReleaseIds().add(release.getId());
            milestoneRepository.save(milestone);
        }
        return new AssociationResponse(milestone.getId(), release.getId(), "Release successfully associated with milestone.");
    }
}
