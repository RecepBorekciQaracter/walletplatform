package com.example.walletplatform.exceptions;

import com.example.walletplatform.models.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    LocalDateTime timestamp = LocalDateTime.now();

    @ExceptionHandler(WalletNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleWalletNotFoundException(WalletNotFoundException e) {
        LocalDateTime timestamp = LocalDateTime.now();

        ErrorResponse error = new ErrorResponse(e.getMessage(), timestamp);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(InvalidAmountException.class)
    public ResponseEntity<ErrorResponse> handleInvalidAmountException(InvalidAmountException e) {
        LocalDateTime timestamp = LocalDateTime.now();

        ErrorResponse error = new ErrorResponse(e.getMessage(), timestamp);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(InvalidWalletCodeException.class)
    public ResponseEntity<ErrorResponse> handleInvalidWalletCodeException(InvalidWalletCodeException e) {
        LocalDateTime timestamp = LocalDateTime.now();

        ErrorResponse error = new ErrorResponse(e.getMessage(), timestamp);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(InsufficientFundsException.class)
    public ResponseEntity<ErrorResponse> handleInsufficientFundsException(InsufficientFundsException e) {
        LocalDateTime timestamp = LocalDateTime.now();

        ErrorResponse error = new ErrorResponse(e.getMessage(), timestamp);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}