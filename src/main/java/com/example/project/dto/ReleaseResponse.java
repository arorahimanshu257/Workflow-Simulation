package com.example.project.dto;

public class ReleaseResponse {
    private String id;
    private String projectId;
    private String tag;
    private String description;
    private String milestoneId;

    public ReleaseResponse() {}

    public ReleaseResponse(String id, String projectId, String tag, String description, String milestoneId) {
        this.id = id;
        this.projectId = projectId;
        this.tag = tag;
        this.description = description;
        this.milestoneId = milestoneId;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getProjectId() { return projectId; }
    public void setProjectId(String projectId) { this.projectId = projectId; }
    public String getTag() { return tag; }
    public void setTag(String tag) { this.tag = tag; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getMilestoneId() { return milestoneId; }
    public void setMilestoneId(String milestoneId) { this.milestoneId = milestoneId; }
}
