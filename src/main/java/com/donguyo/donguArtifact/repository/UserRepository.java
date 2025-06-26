package com.donguyo.donguArtifact.repository;

import com.donguyo.donguArtifact.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long>{
    // 유저네임 중복 확인
    boolean existsByUsername(String username);

    // 이메일 중복 확인
    boolean existsByEmail(String email);

    Optional<UserEntity> findByUsername(String username);

}
