package com.fullstack.BackenExT.exeption;

import com.fullstack.BackenExT.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(e.getMessage());
        errorResponse.setStatus(500);
        errorResponse.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_ACCEPTABLE);
    }

}
