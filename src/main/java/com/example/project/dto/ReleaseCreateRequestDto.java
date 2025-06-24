// Absolute path: /app/0453677a-abca-45f1-be15-ad27f44922f6/src/main/java/com/example/project/dto/ReleaseCreateRequestDto.java

```java
package com.example.project.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ReleaseCreateRequestDto {
    @NotBlank
    @Size(max = 255)
    private String tag;

    public String getTag() { return tag; }
    public void setTag(String tag) { this.tag = tag; }
}
```
