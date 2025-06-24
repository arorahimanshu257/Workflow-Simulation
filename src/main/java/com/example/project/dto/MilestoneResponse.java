package com.example.project.dto;

import java.time.LocalDate;
import java.util.List;

public class MilestoneResponse {
    private String id;
    private String projectId;
    private String title;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private String state;
    private List<String> releaseIds;

    public MilestoneResponse() {}

    public MilestoneResponse(String id, String projectId, String title, String description, LocalDate startDate, LocalDate endDate, String state, List<String> releaseIds) {
        this.id = id;
        this.projectId = projectId;
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.state = state;
        this.releaseIds = releaseIds;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getProjectId() { return projectId; }
    public void setProjectId(String projectId) { this.projectId = projectId; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
    public String getState() { return state; }
    public void setState(String state) { this.state = state; }
    public List<String> getReleaseIds() { return releaseIds; }
    public void setReleaseIds(List<String> releaseIds) { this.releaseIds = releaseIds; }
}
