package com.example.security_jwt_pr.controller;

import com.example.security_jwt_pr.dto.AddUserRequest;
import com.example.security_jwt_pr.dto.LoginUserDto;
import com.example.security_jwt_pr.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> userSave(@Valid @RequestBody AddUserRequest addUserRequest){
        Long createdId = userService.save(addUserRequest);
        log.info("생성된 유저의 id {}", createdId);
        return ResponseEntity.ok().body("회원가입이 올바르게 되었습니다.");
    }

    @PostMapping("/signin")
    public ResponseEntity<?> login(@Valid @RequestBody LoginUserDto userDto){
         String existUserId = userService.existUser(userDto);
         return ResponseEntity.ok().body("존재하는 userId : " + existUserId);
    }


}
