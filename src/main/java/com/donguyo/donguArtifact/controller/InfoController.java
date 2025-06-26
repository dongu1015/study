package com.donguyo.donguArtifact.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/info")
public class InfoController {

    @PostMapping("/information")
    public String information(@RequestParam String info){
        System.out.println(info);
        return info;
    }
}
