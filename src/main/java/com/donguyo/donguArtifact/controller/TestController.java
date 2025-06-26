package com.donguyo.donguArtifact.controller;
import org.springframework.web.bind.annotation.*;

@RestController //RestAPI 컨트롤러
public class TestController {

    @GetMapping("/hello") //GetMapping 어노테이션 /hello 이동시 발동됨
    public String hello(){
        return "Hello World";
    }

    @GetMapping("/donguyo")
    public String dongu(){
        return "이곳은 동구요의 비밀 공간 입니다.";
    }
}

