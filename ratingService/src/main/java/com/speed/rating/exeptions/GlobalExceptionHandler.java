package com.speed.rating.exeptions;

import com.speed.rating.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourceNotFoundException ex)
    {
        String message = ex.getMessage();
        ApiResponse response = ApiResponse.builder().message(message).success(true).httpStatus(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<>(response,response.getHttpStatus());
    }
}