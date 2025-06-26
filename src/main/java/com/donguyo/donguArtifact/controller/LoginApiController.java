package com.donguyo.donguArtifact.controller;

import com.donguyo.donguArtifact.dto.LoginRequestDTO;
import com.donguyo.donguArtifact.dto.LoginResponseDTO;
import com.donguyo.donguArtifact.entity.UserEntity;
import com.donguyo.donguArtifact.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class LoginApiController {

    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO requestDTO, HttpSession session) {
        UserEntity user = userService.validateUser(requestDTO.getUsername(), requestDTO.getPassword());

        if (user == null) {
            return ResponseEntity
                    .status(401)
                    .body(LoginResponseDTO.builder()
                            .status("fail")
                            .message("아이디 또는 비밀번호가 틀렸습니다.")
                            .build());
        }

        // 세션에 사용자 정보 저장
        session.setAttribute("loginUser", user);

        return ResponseEntity.ok(LoginResponseDTO.builder()
                .status("success")
                .message("로그인 성공")
                .username(user.getUsername())
                .build());
    }
}
