package com.example.walletplatform.exceptions;

public class InvalidWalletCodeException extends RuntimeException {
    public InvalidWalletCodeException(String message) {
        super(message);
    }
    public InvalidWalletCodeException() {
        super("Invalid wallet code");
    }
}
