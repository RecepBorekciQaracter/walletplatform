package com.example.walletplatform.exceptions;

public class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException(String message) {
        super(message);
    }
    public InsufficientFundsException() {
        super("Insufficient funds");
    }
}
