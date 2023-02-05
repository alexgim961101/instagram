package com.cos.instagram.config.auth;

import com.cos.instagram.domain.user.User;
import com.cos.instagram.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// loginProcessingUrl에 등록한 Url로 요청이 오면 로그인 데이터를 UserDetailsService로 넘김
@Slf4j
@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    // 패스워드는 시큐리티가 알아서 비교해주기 때문에 유저네임만 잘 비교해주면 됨
    // 리턴이 정상적으로 되면 자동으로 UserDetails타입을 세션으로 만들어줌
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("로그인 처리 프로세스 실행");

        User userEntity = userRepository.findByUsername(username);
        if(userEntity == null) return null;
        else {
            return new PrincipalDetails(userEntity);
        }
    }
}
