package com.donguyo.donguArtifact.controller;

import com.donguyo.donguArtifact.dto.NoteRequestDTO;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoteController {

    @PostMapping("/notes")
    public String note(@ModelAttribute NoteRequestDTO noteDto){
        System.out.println("제목 : " + noteDto.getTitle());
        System.out.println("내용 : " + noteDto.getContent());
        return "OK";
    }

    @PostMapping("/notes/json")
    public String noteJson(@RequestBody NoteRequestDTO jsonDto ) {
        System.out.println(jsonDto);
        return "json OK";
    }
}
