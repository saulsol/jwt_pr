package com.example.security_jwt_pr.dto;

import com.example.security_jwt_pr.error.ErrorCode;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
public class ErrorDto {
    private HttpStatus httpStatus;
    private String message;
    private List<String> errors;

    public ErrorDto(HttpStatus httpStatus, String message, List<String> errors){
        this.httpStatus = httpStatus;
        this.message = message;
        this.errors = errors;
    }

    public ErrorDto(HttpStatus httpStatus, String message, String error) {
        this.httpStatus = httpStatus;
        this.message = message;
        this.errors = List.of(error);
    }

    public static ErrorDto toErrorDto(ErrorCode errorCode){
        return new ErrorDto(
                errorCode.getHttpStatus(),
                errorCode.name(),
                errorCode.getDetail()
        );
    }


}
