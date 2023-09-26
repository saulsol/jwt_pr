package com.example.security_jwt_pr.exceptionHandle;

import com.example.security_jwt_pr.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationException(MethodArgumentNotValidException ex){
        BindingResult bindingResult = ex.getBindingResult();
        List<ErrorDto> errorDtoList = new ArrayList<>();
        for(FieldError fieldError : bindingResult.getFieldErrors()){
            ErrorDto errorDto = new ErrorDto(HttpStatus.BAD_REQUEST, "VALIDATION_CHECK : " + fieldError.getField(), fieldError.getDefaultMessage());
            errorDtoList.add(errorDto);
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDtoList);
    }
}
