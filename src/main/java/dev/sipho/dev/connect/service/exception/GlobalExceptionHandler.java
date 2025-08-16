package dev.sipho.dev.connect.service.exception;

import dev.sipho.dev.connect.service.dto.common.ApiResponse;
import dev.sipho.dev.connect.service.util.ResponseUtil;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Void>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        var errors = new HashMap<String, String>();
        ex.getFieldErrors().forEach(fieldError -> errors.put(fieldError.getField(), fieldError.getDefaultMessage()));

        return ResponseEntity
                .badRequest()
                .body(ResponseUtil.failure(null, "Bad request", errors));
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ApiResponse<Void>> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        var errors = new HashMap<String, String>();
        errors.put("error", "Duplicate username or email");

        return ResponseEntity
                .badRequest()
                .body(ResponseUtil.failure(null, "Database error", errors));

    }

    @ExceptionHandler(DevConnectUserException.class)
    public ResponseEntity<ApiResponse<Void>> handleDevConnectUserException(DevConnectUserException ex){
        return ResponseEntity
                .badRequest()
                .body(ResponseUtil.failure(null, "Validation errors", ex.getErrors()));
    }

    @ExceptionHandler(DevConnectUserNotFoundException.class)
    public ResponseEntity<ApiResponse<Void>> handleDevConnectUserNotFoundException(DevConnectUserException ex){
        return ResponseEntity
                .notFound()
                .build();
    }

    // Make use of this for other not found exceptions and handle generically
}
