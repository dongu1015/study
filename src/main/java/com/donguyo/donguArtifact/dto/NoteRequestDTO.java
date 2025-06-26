package com.donguyo.donguArtifact.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class NoteRequestDTO {
    private String title;
    private String content;

    public NoteRequestDTO(){
    }
}
