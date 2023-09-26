package com.example.security_jwt_pr.controller;

import com.example.security_jwt_pr.jwt.TokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class DoSomethingController {


    @GetMapping("/doSomething")
    public ResponseEntity<?> doSomething(@AuthenticationPrincipal String username){
        return ResponseEntity.ok().body("인증된 유저 기본키 : " + username);
    }
}
