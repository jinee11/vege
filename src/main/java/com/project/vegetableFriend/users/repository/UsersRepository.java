package com.project.vegetableFriend.users.repository;

import com.project.vegetableFriend.users.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {

    //문자로된 이메일로 중복여부 검색하겠다
    //결과가 있을수도 없을 수도 있다
    //Optional<Users> findByEmail(String email);
    Users findByEmail(String email); //이메일로 받아오기

}
