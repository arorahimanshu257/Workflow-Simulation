package com.example.project.repository;

import com.example.project.entity.Milestone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MilestoneRepository extends JpaRepository<Milestone, Long> {
    // Custom query methods can be added here
}
