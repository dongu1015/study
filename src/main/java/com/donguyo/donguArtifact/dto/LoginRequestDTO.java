package com.donguyo.donguArtifact.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
// 롬복 어노테이션
// @Getter: getUsername(), getPassword() 자동 생성
// @Setter: setUsername(), setPassword() 자동 생성
// @NoArgsConstructor: 기본 생성자 생성
@Getter
@Setter
@NoArgsConstructor
public class LoginRequestDTO {
    // 여기에 로그인할 때 필요한 데이터 필드 작성
    private String username;
    private String password;


}