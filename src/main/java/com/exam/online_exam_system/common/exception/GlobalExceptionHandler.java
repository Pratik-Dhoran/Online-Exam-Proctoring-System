package com.exam.online_exam_system.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.exam.online_exam_system.common.dto.ErrorResponse;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<?> handleApiException(ApiException ex) {

        ErrorResponse error = new ErrorResponse(
                ex.getMessage(),
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now()
        );

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
