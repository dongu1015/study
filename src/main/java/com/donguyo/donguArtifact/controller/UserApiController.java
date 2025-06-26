package com.donguyo.donguArtifact.controller;

import com.donguyo.donguArtifact.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*; // @PostMapping, @RequestBody 등
import com.donguyo.donguArtifact.dto.UserRequestDTO; // 우리가 아까 만든 DTO
import com.donguyo.donguArtifact.dto.UserResponseDTO;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;

    @PostMapping("/signup") // 경로 설정
    public ResponseEntity<UserResponseDTO> signup(@RequestBody UserRequestDTO requestDTO){
        // 서비스 호출함 -> 서비스에서 회원가입 로직 실행
        UserResponseDTO responseDTO = userService.singup(requestDTO);

        // 실행 후 응답 반환
        return ResponseEntity.ok(responseDTO);
    }
}
