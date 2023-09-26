package com.example.security_jwt_pr.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginUserDto {
    @Email(message = "형식에 맞는 이메일을 입력하셔야 합니다.")
    private String email;
}
