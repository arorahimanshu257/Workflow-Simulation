// Absolute path: /app/0453677a-abca-45f1-be15-ad27f44922f6/src/main/java/com/example/project/dto/ReleaseAssociationRequestDto.java

```java
package com.example.project.dto;

import jakarta.validation.constraints.NotNull;

public class ReleaseAssociationRequestDto {
    @NotNull
    private Long milestoneId;

    @NotNull
    private Long releaseId;

    public Long getMilestoneId() { return milestoneId; }
    public void setMilestoneId(Long milestoneId) { this.milestoneId = milestoneId; }

    public Long getReleaseId() { return releaseId; }
    public void setReleaseId(Long releaseId) { this.releaseId = releaseId; }
}
```
