package com.cos.security.config.auth;


// Security가 "/login" 주소로 요청이 오면 낚아채서 로그인을 진행시킨다
// 로그인을 진행이 완료가 되면 Security session을 만들어준다(Security ContextHolder라는 키값에 넣어준다)
// security가 만드는 session에 들어갈 수 있는 Object가 정해져있다.
//  => Authentication 타입의 객체(안에 User정보가 있어야됨)
// User 객체 타입 -> UserDetails 타입 객체
// 즉, Security Session에 Authentication 객체가 있고
// 이 안에 UserDetails 타입의 객체가 있어서 이 것을 통해 User 객체에 접근할 수 o

import com.cos.security.model.User_temp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;


public class PrincipalDetails implements UserDetails {
    // UserDetails를 구현함으로써 PrincipleDetails는 UserDetails와 같은 타입이됬다.

    private User_temp user_temp; // 콤포지션 변수
    public PrincipalDetails(User_temp user_temp){
        this.user_temp = user_temp;
    }

    // 해당 user의 권한을 return하는 함수
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collect = new ArrayList<>();
        collect.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return user_temp.getRole();
            }
        });
        return collect;
    }

    @Override
    public String getPassword() {
        return user_temp.getPassword();
    }

    @Override
    public String getUsername() {
        return user_temp.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        // 1년동안 회원이 로그인을 안하면 휴먼계정으로 하기로 한다면?
        // model/User에서  loginDate(로그인한 시점 기록)라는 컬럼이 필요하다
        // logtime = user.getLogindDte
        // now_teim - logtime 이 1년을 초과하면 return false;
        return true;
    }
}
