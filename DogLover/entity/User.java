package com.LoversDogs.Lovers.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;


@ToString
@Data
@NoArgsConstructor
//사용자 로그인

public class User implements UserDetails {
    //UserDetails 상속받아 사용자 인증 객체로 사용할 수 있도록 설정(사용자 정보를 담는 엔티티 클래스)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String phone;
    @Column(name = "email", updatable = false, unique = true)
    //updatable 수정 시에 매핑 여부를 결정(default: true)
    private String email;
    @Column(name = "password", unique = true) //중복 허용 여부
    private String password;
    private String repassword;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Builder
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }


    @Override  //UserDetails 인터페이스의 메서드를 구현
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("user"));
//        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
        //더 오래된 버전과 호환되므로 호환성 면에선 좋을 수 있음

    }

    @Override  //계정 만료 여부 반환
    public boolean isAccountNonExpired() {
        return true;  //true-> 잠금되지 않음
    }

    @Override  //계정 잠금 여부 반환
    public boolean isAccountNonLocked() {
        return true;  //true-> 만료되지 않음
    }

    @Override  //패스워드 만료 여부 반환
    public boolean isCredentialsNonExpired() {
        return true;  //true-> 만료되지 않음
    }

    @Override  //사용자의 계정이 활성화되어 있는지 여부(계정 상태 확인)
    public boolean isEnabled() {
        return true;  //true-> 사용 가능(활성화된 상태)
    }


}
