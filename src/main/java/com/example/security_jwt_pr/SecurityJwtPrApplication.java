package com.example.security_jwt_pr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class SecurityJwtPrApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityJwtPrApplication.class, args);
    }

}
