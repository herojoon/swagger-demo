# swagger-demo

### 프로젝트 스펙

* Spring Framework: Spring Boot 2.7.2
* Java: JDK 17
* Build: Gradle

### 코드 참고

build.gradle에 dependency 추가

* Rest Docs 관련 설정 dependency 추가
* Swagger UI 관련 설정 dependency 추가

Test Code를 이용하여 API의 요청, 응답 정보 작성

* API 통신에 대한 요청, 응답 정보를 테스트 코드로 작성

### Swagger API 문서 생성하기

* IntelliJ 오른쪽 Gradle 실행창에서 Tasks -> documenation -> openapi3 혹은 openapi3AfterClean 더블클릭하여 문서 생성
* 생성된 문서는 기본 루트 프로젝트/build/api-spec 아래 생성 혹은 build.gradle 속 outputDirectory에 정의된 경로 아래로 생성

### Swagger UI 실행시키기

* 프로젝트를 Run 하고 application.yml에 정의한 Path로 호출하면 됨
* 호출 URL: http://localhost:8080/docs/swagger-ui/index.html