package com.donguyo.donguArtifact.service;

import com.donguyo.donguArtifact.dto.UserRequestDTO;
import com.donguyo.donguArtifact.dto.UserResponseDTO;
import com.donguyo.donguArtifact.entity.UserEntity;
import com.donguyo.donguArtifact.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDateTime;

@Service // 스프링이 이 클래스를 서비스로 인식하게 함
@RequiredArgsConstructor // final로 선언된 필드를 자동으로 주입함
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); // 🔐 암호화기
    public UserResponseDTO singup(UserRequestDTO requestDTO){

        // 1. 중복 확인 (유저네임 이메일 중복검사)
        if (userRepository.existsByUsername(requestDTO.getUsername())) {
            throw new IllegalArgumentException("이미 존재하는 아이디입니다.");
        }

        if (userRepository.existsByEmail(requestDTO.getEmail())) {
            throw new IllegalArgumentException("이미 존재하는 이메일입니다.");
        }

        // 2. DTO -> Entity 변환

        // 비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(requestDTO.getPassword());

        UserEntity user = UserEntity.builder()
                .username(requestDTO.getUsername())
                .password(encodedPassword) // 암호화된 비밀번호
                .email(requestDTO.getEmail())
                .createAt(LocalDateTime.now())
                .build();

        // 3. DB 저장
        userRepository.save(user);

        // 4.  응답 DTO 생성 후 리턴
        return UserResponseDTO.builder()
                .status("success")
                .message("회원가입이 완료되었습니다.")
                .username(user.getUsername())
                .build();

    }

    public UserEntity validateUser(String username, String password) {
        UserEntity user = userRepository.findByUsername(username).orElse(null);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return user;
        }
        return null;
    }

}
