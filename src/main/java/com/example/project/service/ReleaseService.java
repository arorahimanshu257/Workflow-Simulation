package com.example.project.service;

import com.example.project.dto.ReleaseCreateRequest;
import com.example.project.dto.ReleaseResponse;
import com.example.project.entity.Release;
import com.example.project.exception.DuplicateReleaseTagException;
import com.example.project.exception.ReleaseNotFoundException;
import com.example.project.repository.ReleaseRepository;
import com.example.project.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReleaseService {
    private final ReleaseRepository releaseRepository;

    @Autowired
    public ReleaseService(ReleaseRepository releaseRepository) {
        this.releaseRepository = releaseRepository;
    }

    @Transactional
    public ReleaseResponse createRelease(ReleaseCreateRequest request) {
        // Check for unique tag within project
        Optional<Release> existing = releaseRepository.findByProjectIdAndTag(request.getProjectId(), request.getTag());
        if (existing.isPresent()) {
            throw new DuplicateReleaseTagException("Release tag must be unique within the project.");
        }
        Release release = new Release();
        release.setProjectId(request.getProjectId());
        release.setTag(request.getTag());
        release.setDescription(request.getDescription());
        release.setMilestoneId(null); // Not associated initially
        Release saved = releaseRepository.save(release);
        return toResponse(saved);
    }

    public ReleaseResponse getReleaseById(String id) {
        Release release = releaseRepository.findById(id)
                .orElseThrow(() -> new ReleaseNotFoundException("Release not found: " + id));
        return toResponse(release);
    }

    public List<ReleaseResponse> getReleasesByProject(String projectId) {
        return releaseRepository.findByProjectId(projectId)
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    private ReleaseResponse toResponse(Release release) {
        return new ReleaseResponse(
                release.getId(),
                release.getProjectId(),
                release.getTag(),
                release.getDescription(),
                release.getMilestoneId()
        );
    }
}
