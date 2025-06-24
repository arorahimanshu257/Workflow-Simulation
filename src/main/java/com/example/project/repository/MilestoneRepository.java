// Absolute path: /app/0453677a-abca-45f1-be15-ad27f44922f6/src/main/java/com/example/project/repository/MilestoneRepository.java

```java
package com.example.project.repository;

import com.example.project.entity.Milestone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MilestoneRepository extends JpaRepository<Milestone, Long> {
    Optional<Milestone> findByTitle(String title);
}
```
