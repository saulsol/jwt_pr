package com.example.security_jwt_pr.service;

import com.example.security_jwt_pr.domain.User;
import com.example.security_jwt_pr.jwt.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;

@RequiredArgsConstructor
@Service
@Transactional
public class TokenService {

    private final TokenProvider tokenProvider;
    private final RefreshTokenService refreshTokenService;
    private final UserService userService;

    // create Access Token
    public String generateAccessToken(User user){
        return tokenProvider.generateToken(user, Duration.ofHours(1));
    }
    // create Refresh Token
    public String generateRefreshToken(User user){
        String refreshToken = tokenProvider.generateToken(user, Duration.ofHours(20));
        refreshTokenService.saveRefreshToken(user, refreshToken);
        return refreshToken;
    }


    public String generateNewAccessToken(String refreshToken){
        if(!tokenProvider.validToken(refreshToken)){
            throw new IllegalArgumentException("Unexpected Exception");
        }
        Long userId = refreshTokenService.findByRefreshToken(refreshToken).getUserId();
        User user = userService.findById(userId);
        return tokenProvider.generateToken(user, Duration.ofHours(2));
    }

}
