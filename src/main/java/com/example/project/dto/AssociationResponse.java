package com.example.project.dto;

public class AssociationResponse {
    private String milestoneId;
    private String releaseId;
    private String message;

    public AssociationResponse() {}

    public AssociationResponse(String milestoneId, String releaseId, String message) {
        this.milestoneId = milestoneId;
        this.releaseId = releaseId;
        this.message = message;
    }

    public String getMilestoneId() { return milestoneId; }
    public void setMilestoneId(String milestoneId) { this.milestoneId = milestoneId; }
    public String getReleaseId() { return releaseId; }
    public void setReleaseId(String releaseId) { this.releaseId = releaseId; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}
