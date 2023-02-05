package com.cos.instagram.web;

import com.cos.instagram.config.auth.PrincipalDetails;
import com.cos.instagram.domain.user.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Slf4j
@Controller
public class UserController {

    @GetMapping("/user/{id}")
    public String profile(@PathVariable Long id) {
        return "user/profile";
    }

    // 유저 로그인에 대한 정보는 세션이 가지고 있음
    // 정확히는 세션 -> SecurityContextHolder -> Authentication -> PrincipalDetails
    // 세션 내 유저 정보 가져오는 방법 1 -> @AuthenticationPrincipal 어노테이션 이용
    // 세션 내 유저 정보 가져오는 방법 2 -> 직접 찾기
    @GetMapping("/user/{id}/update")
    public String update(@PathVariable Long id, @AuthenticationPrincipal PrincipalDetails principalDetails) {
        log.info("세션 정보 : {}", principalDetails.getUser());
//        PrincipalDetails principal = (PrincipalDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        User user = principal.getUser();                // 직접 찾는 방법
        return "user/update";
    }
}
