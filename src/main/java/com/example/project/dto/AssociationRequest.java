package com.example.project.dto;

import jakarta.validation.constraints.NotBlank;

public class AssociationRequest {
    @NotBlank
    private String milestoneId;
    @NotBlank
    private String releaseId;

    public String getMilestoneId() { return milestoneId; }
    public void setMilestoneId(String milestoneId) { this.milestoneId = milestoneId; }
    public String getReleaseId() { return releaseId; }
    public void setReleaseId(String releaseId) { this.releaseId = releaseId; }
}
