package com.donguyo.donguArtifact.pageController;

import com.donguyo.donguArtifact.entity.UserEntity;
import jakarta.persistence.GeneratedValue;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

    @GetMapping("/home")
    public String home(HttpSession session) {
        // 세션에서 로그인 유저 정보를 확인함
        if (session.getAttribute("loginUser") == null){
            // 없으면 로그인 페이지로 리다이렉트
            return "redirect:/login";
        }

        return "home";

    }
}
