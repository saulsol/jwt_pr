package com.example.security_jwt_pr.practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JUnitTest {

    @DisplayName("1 더하기 2는 3이다.")
    @Test
    public void junitTest(){
        int a = 1;
        int b = 2;

        int sum = 3;

        Assertions.assertEquals(a+b, sum);
    }



}
