package com.example.security_jwt_pr.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatAccessTokenRequest {

    private String refreshToken;
}
