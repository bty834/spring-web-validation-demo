package com.example.validation.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
import java.util.Objects;
import java.util.Optional;

/**
 * @author bty
 * @date 2023/2/27
 * @since 17
 **/
@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler
    public ResponseEntity methodArgNotValidExceptionHandler(MethodArgumentNotValidException e) {
        String message = Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage();

        return ResponseEntity.of(Optional.of(Collections.singletonMap("msg", message)));
    }

    @ExceptionHandler
    public ResponseEntity generalExceptionHandler(Exception e) {
        return ResponseEntity.of(Optional.of(Collections.singletonMap("msg", e.getMessage())));
    }
}
