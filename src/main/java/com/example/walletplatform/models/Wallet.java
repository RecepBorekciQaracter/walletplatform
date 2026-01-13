package com.example.walletplatform.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.List;

@Entity
@Table(name="wallets")
public class Wallet {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Email
    @Column(name = "owner_email", nullable = false)
    private String ownerEmail;

    @Column(name = "wallet_code", unique = true, nullable = false)
    @Pattern(regexp = "^WLT-[A-Za-z0-9]+$")
    private String walletCode;

    @Min(0)
    @Column(name = "balance", nullable = false)
    private Double balance;

    @OneToMany(mappedBy = "operations")
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

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }
}
