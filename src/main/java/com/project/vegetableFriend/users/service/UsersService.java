package com.project.vegetableFriend.users.service;

import com.project.vegetableFriend.users.entity.Users;
import com.project.vegetableFriend.users.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2 //log. 로그확인
public class UsersService {

    private final UsersRepository usersRepository;

    public Users saveUsers(Users users){
        //중복확인
        validateDuplicate(users);
        //중복확인후 회원저장
        return usersRepository.save(users);
    }

    public void validateDuplicate(Users users) {
        //이메일로 찾았을때 값이 있는지 없는지 판단
        Users findUsers = usersRepository.findByEmail(users.getEmail());
        //DB에서 이메일이 검색이되면 알림표시
        if(findUsers != null){
            throw new IllegalStateException("이미 등록된 이메일임");
        }
    }
}
