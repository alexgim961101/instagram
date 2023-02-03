package com.cos.instagram.web;

import com.cos.instagram.domain.user.User;
import com.cos.instagram.service.AuthService;
import com.cos.instagram.web.dto.auth.SignupDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor // DI 할 때 사용
@Controller
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    private final AuthService authService;

    @GetMapping("/auth/signin")
    public String signinForm() {
        return "/auth/signin";
    }

    @GetMapping("/auth/signup")
    public String signupForm() {
        return "/auth/signup";
    }

    @PostMapping("/auth/signup")
    public String signup(SignupDto signupDto) {
        logger.info(signupDto.toString());
        User user = signupDto.toEntity();   // 여기서 의문1 : 엔티티에 제약 사항을 걸어둘 경우 이런식의 처리가 가능한가?
        logger.info(user.toString());
        return "/auth/signin";
    }
}
