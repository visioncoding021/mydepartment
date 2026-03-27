package com.rgoswami3414.mydepartment.Exceptions;

import com.rgoswami3414.mydepartment.Dtos.Dtos;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    // ================= NOT FOUND =================
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Dtos.ApiResponse<Void>> handleNotFound(ResourceNotFoundException ex) {

        log.error("Resource not found: {}", ex.getMessage());

        Dtos.ApiError error = Dtos.ApiError.builder()
                .message(ex.getMessage())
                .errorCode("NOT_FOUND")
                .status(HttpStatus.NOT_FOUND.value())
                .build();

        return new ResponseEntity<>(
                Dtos.ApiResponse.<Void>builder()
                        .error(error)
                        .responseTime(LocalDateTime.now())
                        .build(),
                HttpStatus.NOT_FOUND
        );
    }

    // ================= BAD REQUEST =================
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Dtos.ApiResponse<Void>> handleBadRequest(BadRequestException ex) {

        log.warn("Bad request: {}", ex.getMessage());

        Dtos.ApiError error = Dtos.ApiError.builder()
                .message(ex.getMessage())
                .errorCode("BAD_REQUEST")
                .status(HttpStatus.BAD_REQUEST.value())
                .build();

        return new ResponseEntity<>(
                Dtos.ApiResponse.<Void>builder()
                        .error(error)
                        .responseTime(LocalDateTime.now())
                        .build(),
                HttpStatus.BAD_REQUEST
        );
    }
    //================ @Valid ===================
    @ExceptionHandler(org.springframework.web.bind.MethodArgumentNotValidException.class)
    public ResponseEntity<Dtos.ApiResponse<Void>> handleValidation(
            org.springframework.web.bind.MethodArgumentNotValidException ex) {

        String errorMessage = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(err -> err.getField() + ": " + err.getDefaultMessage())
                .reduce((a, b) -> a + ", " + b)
                .orElse("Validation failed");

        Dtos.ApiError error = Dtos.ApiError.builder()
                .message(errorMessage)
                .errorCode("VALIDATION_ERROR")
                .status(HttpStatus.BAD_REQUEST.value())
                .build();

        return ResponseEntity.badRequest().body(
                Dtos.ApiResponse.<Void>builder()
                        .error(error)
                        .responseTime(LocalDateTime.now())
                        .build()
        );
    }

    // ================= GLOBAL =================
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Dtos.ApiResponse<Void>> handleGlobal(Exception ex) {

        log.error("Unexpected error occurred", ex);

        Dtos.ApiError error = Dtos.ApiError.builder()
                .message("Something went wrong")
                .errorCode("INTERNAL_SERVER_ERROR")
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .build();

        return new ResponseEntity<>(
                Dtos.ApiResponse.<Void>builder()
                        .error(error)
                        .responseTime(LocalDateTime.now())
                        .build(),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}