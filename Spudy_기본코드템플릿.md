```java
// ✅ DTO 기본 형식 예시
// 📁 파일명: XxxRequestDto.java

package com.example.dto;

// 📌 @Getter: 필드 값을 반환하는 get메서드를 자동으로 만들어줌
// 📌 @Setter: 필드 값을 설정하는 set메서드를 자동으로 만들어줌
// 📌 @NoArgsConstructor: 기본 생성자(파라미터 없는 생성자)를 자동 생성해줌
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class XxxRequestDto {
    private String field1;
    private String field2;
}
```

```java
// ✅ 응답 DTO 기본 형식 예시
// 📁 파일명: XxxResponseDto.java

package com.example.dto;

// 📌 @AllArgsConstructor: 모든 필드를 인자로 받는 생성자를 자동 생성해줌
// 📌 @Getter, @Setter: 각 필드에 대한 getter/setter 자동 생성
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
public class XxxResponseDto {
    private boolean success;
    private String message;
}
```

```java
// ✅ Controller 기본 형식 예시
// 📁 파일명: XxxController.java

package com.example.controller;

import com.example.dto.XxxRequestDto;
import com.example.dto.XxxResponseDto;

// 📌 @RestController: JSON 기반 응답을 제공하는 컨트롤러임을 나타냄
// 📌 @RequestMapping: 공통 URL 경로 지정
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/xxx")
public class XxxController {

    // 📌 @PostMapping: HTTP POST 요청을 처리
    // 📌 @RequestBody: 요청 본문의 JSON 데이터를 DTO로 바인딩
    @PostMapping
    public XxxResponseDto create(@RequestBody XxxRequestDto dto) {
        return new XxxResponseDto(true, "처리 성공");
    }
}
```

```yaml
# ✅ application.yml 기본 형식 예시

server:
  port: 8080

spring:
  datasource:
    url: jdbc:mysql://localhost:3306/dbname
    username: your_id
    password: your_pw

  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
```