package com.project.vegetableFriend.users.controller;

import com.project.vegetableFriend.users.dto.UsersDTO;
import com.project.vegetableFriend.users.entity.Users;
import com.project.vegetableFriend.users.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@Controller
@RequestMapping("/users")
@RequiredArgsConstructor //fianl 키를 사용해 빈등록
public class UsersController {

    final UsersService usersService;

    @GetMapping("/new")
    public String UsersFrom(Model model){
        model.addAttribute("usersDTO", new UsersDTO());
        return "users/usersForm";
    }

    // restfull 방식. 이름이 똑같아도 어노테이션이 다르니까 ㄱㅊ다
    @PostMapping("/new") //@Valid : 자등으로 유효성 제크해주는 어노테이션
    public String UsersFrom(@Valid UsersDTO usersDTO){
        Users users = Users.createUsers(usersDTO);
        usersService.saveUsers(users);

        return "redirect:/";
    }



}
