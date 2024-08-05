package com.LoversDogs.Lovers.config;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;

//@Configuration  //스프링의 환경설정 파일임을 의미
@EnableWebSecurity  //모든 요청 url이 스프링 시큐리티의 제어를 받도록 만듬

public class SecurityConfig {

    @Autowired
    private UserdetailService userdetailService;


        public UserdetailService userdetailService(UserService userService) {

            String email;
            return username -> userService.findByUserEmail(email);
    }

}
