package com.cos.instagram.service;

import com.cos.instagram.domain.user.User;
import com.cos.instagram.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service // 1. IoC 등록 , 2. 트랜잭션 관리
public class AuthService {

    private static final Logger logger = LoggerFactory.getLogger(AuthService.class);

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional // insert, update, delete 할때는 트랜잭션 필요
    public User signup(User user) {

        String rawPassword = user.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);  // 암호화된 패스워드
        user.setPassword(encPassword);
        user.setRole("ROLE_USER");  // 관리자 ROLE_ADMIN
        User userEntity = userRepository.save(user);
        logger.info(userEntity.toString());
        return userEntity;
    }
}
