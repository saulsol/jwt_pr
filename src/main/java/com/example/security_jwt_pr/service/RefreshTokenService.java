package com.example.security_jwt_pr.service;

import com.example.security_jwt_pr.domain.RefreshToken;
import com.example.security_jwt_pr.domain.User;
import com.example.security_jwt_pr.repository.RefreshTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class RefreshTokenService {
    private final RefreshTokenRepository refreshTokenRepository;

    public void saveRefreshToken(User user, String refreshToken){
        RefreshToken newRefreshToken = RefreshToken.builder()
                .userId(user.getId())
                .refreshToken(refreshToken)
                .build();
        refreshTokenRepository.save(newRefreshToken);
    }


    public RefreshToken findByRefreshToken(String refreshToken){
        return refreshTokenRepository.findByRefreshToken(refreshToken)
                .orElseThrow(()-> new IllegalArgumentException("Unexpected token"));
    }
}
