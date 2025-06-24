// Absolute path: /app/0453677a-abca-45f1-be15-ad27f44922f6/src/main/java/com/example/project/repository/ReleaseRepository.java

```java
package com.example.project.repository;

import com.example.project.entity.Release;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReleaseRepository extends JpaRepository<Release, Long> {
    Optional<Release> findByTag(String tag);
}
```
