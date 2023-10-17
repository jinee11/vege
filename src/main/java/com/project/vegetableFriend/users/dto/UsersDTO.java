package com.project.vegetableFriend.users.dto;


import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Getter @Setter
public class UsersDTO {

    private Long id; //user_id

    @NotEmpty(message = "이메일은 필수 입력 값입니다.")
    @Email(message = "이메일 형식이 잘못되었습니다.")
    private String email;

    @NotEmpty(message = "비밀번호는 필수 입력 값입니다.")
    @Length(min = 4, max = 16, message = "비밀번호는 4자 이상, 16자 이하로 입력해주세요.")
    private String password;

    @NotEmpty(message = "닉네임은 필수 입력 값입니다.")
    private String name;

    @NotEmpty(message = "폰 번호는 필수 입력 값입니다.")
    private String phone;

    @NotEmpty(message = "나이는 필수 입력 값입니다.")
    private int age;

    @NotEmpty(message = "나이는 필수 입력 값입니다.")
    private short gender; //TINYINT

    private LocalDateTime joinDate;
    private LocalDateTime lastUpdate;
}
