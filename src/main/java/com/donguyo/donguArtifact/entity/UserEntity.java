package com.donguyo.donguArtifact.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

//어노테이션	설명
//@Entity	이 자바 클래스는 JPA가 관리하는 DB 테이블이다
//@Table(name = "users")	실제 테이블명을 명시적으로 설정
//@Id	기본 키(PK)로 쓸 필드 지정
//@GeneratedValue	자동 증가 설정 (MySQL의 AUTO_INCREMENT 느낌)
//@Column	컬럼의 제약조건 설정 (nullable, unique 등)
//LocalDateTime	시간 데이터 저장용. JPA에서 자동 처리 가능함

@Entity
@Table(name = "users")
@Setter @Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    // not null, 중복 불가
    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(name = "create_at")
    private LocalDateTime createAt;
}
