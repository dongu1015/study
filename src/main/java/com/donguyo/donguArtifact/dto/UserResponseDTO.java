package com.donguyo.donguArtifact.dto;

import lombok.*;

@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {

    private String status;
    private String message;
    private String username;
}
