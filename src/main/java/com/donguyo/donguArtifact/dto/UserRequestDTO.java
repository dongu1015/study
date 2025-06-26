package com.donguyo.donguArtifact.dto;

import lombok.*;

@Getter @Setter   // 각 필드의 getter/setter 자동 생성
@NoArgsConstructor // 파라미터 없는 생성자 자동 생성
@AllArgsConstructor // 모든 필드를 받는 생성자 자동 생성
@Builder           // 빌더 패턴 사용 가능 (선택적으로 필드 채울 때 유용)
public class UserRequestDTO {
    private String username; // 사용자가 입력한 아이디
    private String password; // 사용자가 입력한 비밀번호
    private String email;    // 사용자가 입력한 이메일 주소
}
