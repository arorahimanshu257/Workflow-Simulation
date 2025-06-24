package com.example.project.util;

import com.example.project.entity.Milestone;
import com.example.project.entity.Release;
import java.time.LocalDate;

public class ValidationUtil {
    private ValidationUtil() {}

    public static boolean isMilestoneDateRangeValid(LocalDate start, LocalDate end) {
        return start != null && end != null && !end.isBefore(start);
    }

    public static boolean isMilestoneTitleUnique(String title, String projectId, java.util.List<Milestone> milestones) {
        return milestones.stream().noneMatch(m -> m.getTitle().equalsIgnoreCase(title) && m.getProjectId().equals(projectId));
    }

    public static boolean isReleaseTagUnique(String tag, String projectId, java.util.List<Release> releases) {
        return releases.stream().noneMatch(r -> r.getTag().equalsIgnoreCase(tag) && r.getProjectId().equals(projectId));
    }
}
