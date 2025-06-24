// Absolute path: /app/0453677a-abca-45f1-be15-ad27f44922f6/src/main/java/com/example/project/dto/MilestoneResponseDto.java

```java
package com.example.project.dto;

import java.time.LocalDate;
import java.util.List;

public class MilestoneResponseDto {
    private Long id;
    private String title;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<ReleaseResponseDto> releases;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }

    public List<ReleaseResponseDto> getReleases() { return releases; }
    public void setReleases(List<ReleaseResponseDto> releases) { this.releases = releases; }
}
```
