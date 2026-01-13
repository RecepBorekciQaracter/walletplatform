package com.example.walletplatform.models;

import jakarta.validation.constraints.*;

import java.util.List;

public class Wallet {
    private Long id;

    @Email
    private String ownerEmail;

    @Pattern(regexp = "^WLT-[A-Za-z0-9]+$")
    private String walletCode;

    @Min(0)
    private Double balance;

    private List<Operation> operations;

    public Wallet() {}
    public Wallet(String ownerEmail, String walletCode, Double balance) {
        this.ownerEmail = ownerEmail;
        this.walletCode = walletCode;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public String getWalletCode() {
        return walletCode;
    }

    public void setWalletCode(String walletCode) {
        this.walletCode = walletCode;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
