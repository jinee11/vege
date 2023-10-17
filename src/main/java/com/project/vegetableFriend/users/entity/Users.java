package com.project.vegetableFriend.users.entity;

import com.project.vegetableFriend.users.dto.UsersDTO;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDateTime;


@Entity
@Table(name = "users")
@Data
@NoArgsConstructor //기본 생성자
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //idx 자동증가
    @Column(name = "user_id")
    private Long id;

    @Column(unique = true)
    private String email; //이메일

    @Column(nullable = false)
    private String password; //비밀번호

    private String name; //닉네임

    private String phone; //휴대폰번호

    private int age; //나이

    private short gender; //성별, TINYINT

    @CreatedDate //생성 시점
    @Column(updatable = false) //생성 시점의 값 유지
    private LocalDateTime joinDate; //회원가입일자

    @LastModifiedBy //마지막 업데이트
    private LocalDateTime lastUpdate; //회원정보수정일자

    public static Users createUsers(UsersDTO userDto){
        Users users = new Users();

        users.setEmail(userDto.getEmail());
        users.setPassword(userDto.getPassword());
        users.setName(userDto.getName());
        users.setPhone(userDto.getPhone());
        users.setAge(userDto.getAge());
        users.setGender(userDto.getGender());

        return users;

    }

}
