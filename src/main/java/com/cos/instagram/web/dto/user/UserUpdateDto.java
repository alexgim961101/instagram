package com.cos.instagram.web.dto.user;

import com.cos.instagram.domain.user.User;
import lombok.Data;

@Data
public class UserUpdateDto {
    private String name;
    private String password;
    private String website;
    private String bio;
    private String tel;
    private String gender;

    // 조금 위험함, 커드 수정이 필요할 예정
    public User toEntity() {
        return User.builder()
                .name(name)          // 여기도 validation 체크 필요
                .password(password)  // 패스워드를 기재 안했으면 DB에 공백이 들어감 -> Validation 체크 필요
                .website(website)
                .bio(bio)
                .phone(tel)
                .gender(gender).build();
    }
}
