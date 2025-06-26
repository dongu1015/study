package com.donguyo.donguArtifact.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NoteResponseDTO {
    private int status;
    private String message;
    private Object data;
}
