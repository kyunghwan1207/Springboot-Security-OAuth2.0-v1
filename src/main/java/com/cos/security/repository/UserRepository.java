package com.cos.security.repository;

import com.cos.security.model.User_temp;
import org.springframework.data.jpa.repository.JpaRepository;
import team_project.beer_community.domain.User;

// CRUD 함수를 JpaRepository가 들고 있음.
// @Repository라는 Annotation이 업ㅅ어도 IoC됨. 
//          이유는 JpaRepositry를 상속했기 때문
//@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User_temp, Integer> {
    
}
