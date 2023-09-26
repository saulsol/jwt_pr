package com.example.security_jwt_pr.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginSuccessDto {

    private String email;
    private String accessToken;
    private String refreshToken;
}
