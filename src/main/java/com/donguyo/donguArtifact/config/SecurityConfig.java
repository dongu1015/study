// 파일 위치: src/main/java/com/donguyo/donguArtifact/config/SecurityConfig.java

package com.donguyo.donguArtifact.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .securityMatcher("/**") // 어떤 경로에 보안 필터 적용할지 지정
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // 모든 요청 허용
                )
                .csrf(csrf -> csrf.disable()) // CSRF 비활성화
                .formLogin(form -> form.disable()); // 기본 로그인 비활성화

        return http.build();
    }
}
