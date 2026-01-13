package com.example.walletplatform.entities;

import com.example.walletplatform.enums.Type;
import com.example.walletplatform.models.Operation;
import com.example.walletplatform.models.Wallet;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Entity
@Table(name="wallets")
public class WalletEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String ownerEmail;

    @Column(unique = true, nullable = false)
    private String walletCode;

    private Double balance;

    @OneToMany(mappedBy = "wallet", cascade = CascadeType.ALL)
    private List<OperationEntity> operations;

    public WalletEntity() {
        this.operations = new ArrayList<>();
    }

    public WalletEntity(String ownerEmail, String walletCode, Double balance) {
        this.ownerEmail = ownerEmail;
        this.walletCode = walletCode;
        this.balance = balance;
        this.operations = new ArrayList<>();
    }

    public void addFunds(Double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }
        this.balance += amount;
        OperationEntity operation = new OperationEntity(Type.CREDIT, amount, false);
        if (amount > 7500) {
            operation.setSuspicious(true);
        }
        operation.setWallet(this);
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
        OperationEntity operation = new OperationEntity(Type.DEBIT, amount, false);
        operation.setWallet(this);
        operations.add(operation);
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

    public List<OperationEntity> getOperations() {
        return operations.stream().sorted(Comparator.comparing(OperationEntity::getTimestamp).reversed()).toList();
    }

    public void setOperations(List<OperationEntity> operations) {
        this.operations = operations;
    }

}
