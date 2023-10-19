package com.project.vegetableFriend.users.controller;

import com.project.vegetableFriend.users.dto.UsersDTO;
import com.project.vegetableFriend.users.entity.Users;
import com.project.vegetableFriend.users.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@Controller
@RequestMapping("/users")
@RequiredArgsConstructor //final 키를 사용해 빈등록
public class UsersController {

    final UsersService usersService;

    @GetMapping("/new")
    public String usersForm(Model model){
        model.addAttribute("usersDTO", new UsersDTO());
        return "users/joinForm";
    }

    // restfull 방식. 이름이 똑같아도 어노테이션이 다르니까 ㄱㅊ다
    @PostMapping("/new") //@Valid : 자등으로 유효성 제크해주는 어노테이션
    public String UsersFrom(@Valid UsersDTO usersDTO
                    , BindingResult bindingResult, Model model){//에러에 대한 결과를 받아옴
                //annotation에서 에러가 있으면 다시 usersForm으로 돌아간다 -> 바인딩 에러 시 처리

        if(bindingResult.hasErrors()){ //바인딩리절트가 하나라도 에러인 경우
            return "users/joinForm";
        }
        try{//회원가입을 처리하는 구문
            Users users = Users.createUsers(usersDTO);
            usersService.saveUsers(users);
        }catch (IllegalStateException e){//회원가입 처리시 문제가 생기면 에러메시지 띄우기

        }
        Users users = Users.createUsers(usersDTO);
        usersService.saveUsers(users);

        return "redirect:/";
    }



}
