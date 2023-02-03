package com.cos.instagram.domain.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

// JPA : Java Persistance Api (자바로 데이터를 영구적으로 저장할 수 있는 API 제공)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity   // DB에 테이블 생성
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   // 번호 증가 전략이 DB를 따라감
    private Long id;
    @Column(length = 20, unique = true)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    private String website;
    private String bio;       // 자기소개
    private String phone;
    private String gender;

    private String profileImageUrl;

    private String role;

    private LocalDateTime createDate;

    @PrePersist // DB에 INSERT 되기 직전에 실행
    public void createDate() {
        this.createDate = LocalDateTime.now();
    }
}
