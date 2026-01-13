package com.example.walletplatform.models;

import com.example.walletplatform.enums.Type;
import jakarta.validation.constraints.*;

import java.util.Comparator;
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

    public void addFunds(Double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }
        this.balance += amount;
        Operation operation = new Operation(Type.CREDIT, amount, false);
        if (amount > 7500) {
            operation.setSuspicious(true);
        }
        operations.add(operation);
    }

    public void spendFunds(Double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }
        if (amount > this.balance ) {
            throw new IllegalArgumentException("Amount cannot be greater than balance");
        }
        this.balance -= amount;
        Operation operation = new Operation(Type.DEBIT, amount, false);
    }

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

    public List<Operation> getOperations() {
        return operations.stream().sorted(Comparator.comparing(Operation::getTimestamp).reversed()).toList();
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }
}
