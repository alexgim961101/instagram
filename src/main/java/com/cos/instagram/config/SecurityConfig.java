package com.cos.instagram.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity // 해당 파일로 시큐리티 활성화
@Configuration // IoC에 등록
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // super 삭제 -> 기존 시큐리티가 가지고 있는 기능 다 비활성화
        http.authorizeRequests()     // 권한이 필요한 요청들은 다음 antMatcherㄴ와 같다
                .antMatchers("/", "/user/**", "/image/**", "/subscribe/**", "/comment/**").authenticated()  // 해당 요청들은 인증이 필요하다
                .anyRequest().permitAll()  // 그 외에 요청들은 다 허가한다.
                .and()
                .formLogin()   // 인증이 필요한 경우 formLogin을 할거야
                .loginPage("/auth/signin") // 로그인 페이지는 다음과 같은 url이고 너희는 이쪽으로 이동할거야
                .defaultSuccessUrl("/");   // 로그인 성공시 너희는 다음과 같은 url로 이동하게 될거야
    }
}
