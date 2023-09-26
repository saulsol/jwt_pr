package com.example.security_jwt_pr.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddUserRequest {

    @NotEmpty(message = "이메일은 필수값입니다.")
    @Email(message = "형식에 맞는 이메일을 입력하셔야 합니다.")
    private String email;
    @NotEmpty(message = "패스워드는 필수값입니다.")
    private String password;

}
