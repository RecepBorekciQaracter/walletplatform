package com.example.walletplatform.exceptions;

public class WalletNotFoundException extends RuntimeException {
    public WalletNotFoundException(String message) {
        super(message);
    }
    public WalletNotFoundException() {
        super("Wallet not found");
    }
}
