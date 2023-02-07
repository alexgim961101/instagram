package com.cos.instagram.web.api;

import com.cos.instagram.config.auth.PrincipalDetails;
import com.cos.instagram.domain.user.User;
import com.cos.instagram.service.UserService;
import com.cos.instagram.web.dto.CMRespDto;
import com.cos.instagram.web.dto.user.UserUpdateDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;

    @PutMapping("/api/user/{id}")
    public CMRespDto<?> update(@PathVariable Long id, UserUpdateDto userUpdateDto, @AuthenticationPrincipal PrincipalDetails principalDetails) {
        log.info(userUpdateDto.toString());

        User userEntity = userService.modify(id, userUpdateDto.toEntity());
        principalDetails.setUser(userEntity);  // 세션 정보 변경
        return new CMRespDto<>(1, "회원 수정 와료", userEntity);
    }
}
