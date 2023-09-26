package com.example.security_jwt_pr.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    // 400
    ALREADY_EXISTS(HttpStatus.BAD_REQUEST, "이미 존재하는 ID입니다.")
    ;


    private final HttpStatus httpStatus;
    private final String detail;



}