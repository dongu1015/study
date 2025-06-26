package com.donguyo.donguArtifact.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

// @Getter: getSuccess(), getMessage() 자동 생성
// @Setter: setSuccess(), setMessage() 자동 생성
// @AllArgsConstructor: 모든 필드를 매개로 받는 생성자 자동 생성
@Getter
@AllArgsConstructor
@Builder
@Setter

public class LoginResponseDTO {
    private String status;
    private String message;
    private String username;
}
