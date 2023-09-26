package com.example.security_jwt_pr.service;

import com.example.security_jwt_pr.domain.User;
import com.example.security_jwt_pr.dto.AddUserRequest;
import com.example.security_jwt_pr.dto.LoginUserDto;
import com.example.security_jwt_pr.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class UserService implements UserDetailsService {

    // 스프링 시큐리티에서 사용자 정보를 가져오는 인터페이스

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Long save(AddUserRequest addUserRequest){
        return userRepository.save(
                User.builder()
                        .email(addUserRequest.getEmail())
                        .password(bCryptPasswordEncoder.encode(addUserRequest.getPassword()))
                        .build()
        ).getId();
    }

    public String existUser(LoginUserDto userDto){
        User user = loadUserByUsername(userDto.getEmail());
        return user.getEmail();
    }

    public User findById(Long userId){
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Unexpected user"));
    }


    // 사용자 이름(email) 으로 사용자의 정보를 가져오는 메서드
    // 원래는 UserDetail인데 User 클래스를 UserDetail로 확장했으니깐 가능
    @Override
    public User loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).orElseThrow(
                ()-> new IllegalArgumentException(email)
        );
    }


}
