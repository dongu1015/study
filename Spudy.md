동구요닷컴 개발 이론 학습 총정리 (자세한 설명 버전)

[1. HTTP란?]

-   HTTP(HyperText Transfer Protocol)는 웹에서 서버와 클라이언트가 데이터를 주고받기 위한 통신 규칙이다.
-   요청(Request): 브라우저가 서버에 "이거 주세요" 하는 것.
-   응답(Response): 서버가 "여기요~" 하고 주는 것.
-   예: GET은 데이터를 달라고 요청, POST는 데이터를 보낼 때 사용.
-   Stateless(무상태): 요청할 때마다 서버는 "처음 보는 척" 한다. 상태 유지가 안 되기 때문에 로그인 같은 기능은 별도로 쿠키나 세션으로 관리함.

[2. 프론트엔드 vs 백엔드]

-   프론트엔드: 사용자가 직접 보는 화면, HTML/CSS/JS로 구성.
-   백엔드: 보이지 않는 부분. 서버에서 데이터 처리, 저장, 응답 등을 담당.
-   프론트는 요청 보내는 클라이언트, 백엔드는 요청 받는 서버.

[3. 클라이언트와 서버]

-   클라이언트: 요청하는 컴퓨터 (예: 브라우저).
-   서버: 요청을 받고 응답을 주는 컴퓨터.
-   예: 동구가 네이버를 열면, 브라우저가 클라이언트, 네이버 서버가 서버.

[4. JSON이란?]

-   JavaScript Object Notation.
-   데이터를 key-value 형태로 주고받기 위한 포맷.
-   읽기 쉽고, 프론트와 백 모두 호환이 잘 됨.
-   예: {"name": "동구", "age": 25}

[5. REST API란?]

-   REST: Representational State Transfer. 자원을 표현하고 상태를 전송하는 구조.
-   자원은 URL로 표현, 동작은 HTTP 메서드로 표현.
-   예:
    -   GET /users → 사용자 목록
    -   POST /users → 사용자 생성
    -   PUT /users/1 → 1번 사용자 수정
    -   DELETE /users/1 → 1번 사용자 삭제
-   RESTful하게 만든다는 건 동작을 URL이 아닌 HTTP 메서드로 표현하는 것.

[6. 프레임워크란?]

-   반복적이고 복잡한 작업을 대신해주는 개발 도구.
-   Spring Boot: 자바 웹 개발용 프레임워크. 설정을 자동화해줌.
-   React: 프론트엔드 프레임워크. 컴포넌트 단위로 화면을 구성함.

[7. Spring Boot의 역할]

-   스프링을 쉽게 쓸 수 있도록 만든 프레임워크.
-   @SpringBootApplication 어노테이션으로 자동 설정 시작.
-   내장 톰캣으로 별도 서버 설치 없이 바로 실행 가능.

[8. Spring Boot 프로젝트 구조]

-   build.gradle: 라이브러리와 설정 관리.
-   src/main/java: 자바 소스코드.
-   src/main/resources: 설정파일, 정적파일(CSS, JS, 이미지 등).
-   application.yml: 포트, DB정보, 로깅, 파일업로드 등 모든 환경 설정.

[9. application.yml 예시]
server:
port: 8081

spring:
datasource:
url: jdbc:mysql://localhost:3306/testdb
username: test
password: 1234

jpa:
hibernate:
ddl-auto: update
show-sql: true

[10. Gradle 설정 파일]

-   plugins: 어떤 종류의 프로젝트인지 정의 (예: java, spring-boot)
-   dependencies: 필요한 라이브러리 명시. 예:
    -   spring-boot-starter-web: 웹 서버 + JSON 처리
    -   spring-boot-starter-data-jpa: JPA 사용
    -   mysql-connector-j: MySQL DB 연동

[11. 컴퓨터 네트워크 관점]

-   DNS: 도메인 이름을 IP 주소로 변환.
-   IP: 서버를 찾기 위한 주소.
-   포트: 컴퓨터 안에서 실행 중인 서비스 식별 번호 (예: 80, 443).
-   TCP: 연결형 프로토콜. 데이터 손실 방지.
-   HTTP: 웹 통신 형식.
-   HTTPS: 보안이 적용된 HTTP.

[12. MVC 패턴이란?]

-   Model: 데이터 구조 (DTO, Entity 등)
-   View: 사용자에게 보여주는 화면 (HTML, Thymeleaf)
-   Controller: 요청을 받고 Model과 View를 연결
-   REST API에서는 View 없이 JSON 응답만 제공.

[13. 동구요닷컴 주요 기능 설계]

-   파일 업로드, 다운로드, 삭제
-   메모: 마크다운 기반 에디터로 작성/수정
-   캘린더: 일정 등록, 조회, 수정, 삭제
-   폴더/디렉토리 기능
-   검색 기능 (파일명 기준)
-   최근 기록 조회
-   인증 기능 (로그인, 로그아웃)
-   외부 접속 + 도메인 연결
-   SSL 인증서 (Let's Encrypt)
-   Docker + Docker Compose로 통합 구성

[14. 전체 API 설계 흐름 예시]

-   POST /files → 파일 업로드
-   GET /files → 파일 목록 조회
-   GET /files/{filename} → 다운로드
-   DELETE /files/{filename} → 삭제
-   GET /files/recent → 최근 업로드 파일 목록
-   GET /files?keyword=검색어 → 검색

[15. 클라우드 기능 확장]

-   정렬 기능 (이름순, 크기순, 날짜순)
-   태그/설명 메타데이터 저장
-   휴지통 기능
-   압축 다운로드
-   업로드 기록 저장 및 확인
-   서브 디렉토리 이동 / 폴더 생성 / 삭제

16. 어노테이션 기능

-   @Component -> 개발자가 직접 작성한 클래스를 Bean으로 등록할 때 사용함.
-   @Bean -> 외부 라이브러리 등을 Bean으로 등록할 때 사용함
-   @RestController -> View를 사용하지 않고, json 형태로 데이터를 반환하는 Controller를 만들 때 사용함.

17. controller 생성 방법

-   원하는 패키지에 controller.java 파일을 생성함
-   @RestController 어노테이션을 사용하여 클래스를 정의함
-   @GetMapping 등의 어노테이션을 사용하여 요청을 처리하는 메서드를 작성함

18. 메인 클래스 설정

-   @SpringBootApplication 어노테이션 :
-   @Configuration, @EnableAutoConfiguration, @ComponentSan 이 3개의 어노테이션을
-   합친 것으로 Spring Boot 어플리케이션의 시작점을 정의함

19. 컨트롤러를 사용하기 위해선 패키지를 임포트 해줘야됨
    그 두개가 @RestController와 @GetMapping 이 두개가 사용되는데

-   @RestController 가 하는 일
    HTTP 요청을 처리하는 컨트롤러 라는걸 스프링한테 알려줌
    함수의 리턴 값을 그대로 HTTP 응답 바디로 돌려줌
    임포트 -> import org.springframework.web.bind.annotation.RestController;
    결과 :
-   브라우저에 json이나 텍스트가 그대로 응답됨
-   템플릿 엔진 (HTML)은 사용하지 않음

-   @GetMapping 가 하는 일
    브라우저에 /hello 주소로 GET 요청이 들어오면
    해당 메서드가 실행됨

임포트 -> import org.springframework.web.bind.annotation.GetMapping;

여기서 잠깐 !!!!!!!!!!!!!
Mapping 어노테이션은 GET 뿐만 있는게 아님
앞에 있는건 HTTP Request로 GET으로 요청하는것
Post, Put, Delete 가 앞에 붙을 수도 있음
각각 등록, 수정, 삭제를 의미함
@RequestMapping(method=...)의 단축 버전임

-   @PostMapping 가 하는일
    얘는 값을 읽어오는거임 input이랑 비슷한 구조인듯
    이거 말고도 많은 어노테이션이 존재함

20. DTO 란?

-   Data Transter Object
-   계층간에 데이터 교환을 위해 사용되는 객체임
-   Service <-> Controller, Body, Controller 내 핸들러
-   위 계층간 이동 또는 요청에 사용됨

예시 상황

1. 프론트에서 사용자가 메모를 작성함
2. 그걸 POST /notes로 서버에 전송함
3. 백엔드가 그걸 받아서 DB에 저장함

중요한 것

-   json으로 들어온 요청 데이터를 자바에서 **객체**로 바꿔줘야 처리할 수 있음
    -> 이것이 바로 DTO

DTO는 따로 디렉토리를 만들어서 요청을 받는 컨트롤러에 맞는 DTO를 만들어주면 됨

21. lombok
    이게 진짜 개맛도리임 생성자를 자동으로 그냥 만들어줌
    @Getter - Getter 생성자 만들어줌
    @Setter - Setter 생성자 만들어줌
    @NoArgsConstructor 기본 생성자 자동으로 만들어줌

22. @RequestBody
    이건 JSON 형식으로 받아올때 사용하는 어노테이션임
    그래서 DTO 객체를 가져올 때, @RequestBody 이걸 넣어줘야함

23. json 전송 구조
    프론트엔드에서 json으로 값을 전송함
    그러면 이걸 RequestDTO가 값을 받아서 자바 객체로 바꿔줌
    컨트롤러가 그러면 이 값들을 받아와서 뭔가 로직을 걸침.
    그리고 그에 대한 응답을 ResponseDTO에서 알맞게 가져오는거임
    예를 들어서 로그인이라고 치면 아이디랑 비밀번호를 json으로 받고
    그걸 RequestDTO가 객체로 바꿔줌, 컨트롤러는 그걸 가져와서
    입력한 정보가 알맞는 정보인지 조건문을 통해 확인함.
    정보가 맞으면 그에 맞는 응답을 ResponseDTO에서 가져와서 프론트엔드에 전송하고,
    틀리면 또 그거대로 가져와서 프론트엔드에 전송하는거임.
