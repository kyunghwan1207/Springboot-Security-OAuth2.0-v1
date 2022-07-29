package com.cos.security.controller;

import com.cos.security.model.User_temp;
import com.cos.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import team_project.beer_community.domain.User;

@Controller // View를 리턴하겠다
//@EnableJpaRepositories
public class IndexController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    // localhost:8080/
    // localhost:8080
    @GetMapping({"", "/"})
    public String index(){
        // 머스테치 기본폴더 src/main/resources/
        // 뷰리졸버 설정: templates/ ~.mustache 를 읽는대
        // .html로 바꿔보겠음
        return "index";
    }
    
    @GetMapping("/user")
    public @ResponseBody String user(){
        return "user";
    }

    // Spring Security 가 낚아채버림
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/join")
    public String join_get(){
        return "join";
    }
    @PostMapping("/join")
    public String join_post(User_temp user){
        System.out.println(user);
        System.out.println(user.getUsername());
        String rawPassword = user.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        user.setPassword(encPassword);
        userRepository.save(user);
        return "redirect:/login";
    }

    @GetMapping("/admin")
    public @ResponseBody String admin(){
        return "admin";
    }

    @GetMapping("/loginProc")
    public @ResponseBody String loginProc(){
        return "회원가입 완료되었습니다";
    }
}
