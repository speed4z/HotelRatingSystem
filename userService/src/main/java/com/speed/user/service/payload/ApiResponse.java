package com.speed.user.service.payload;

import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class ApiResponse {
    private String message;
    private boolean success;
    private HttpStatus httpStatus;
}
