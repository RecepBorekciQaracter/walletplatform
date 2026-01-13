package com.example.walletplatform.entities;

import com.example.walletplatform.enums.Type;
import com.example.walletplatform.models.Operation;
import com.example.walletplatform.models.Wallet;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "operations")
public class OperationEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "wallet_id")
    private WalletEntity wallet;

    @Column(nullable=false)
    @Enumerated(EnumType.STRING)
    private Type type;

    private Double amount;

    private LocalDateTime timestamp;

    private Boolean suspicious;

    public OperationEntity() {}

    public OperationEntity(Type type, Double amount, Boolean suspicious) {
        this.type = type;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
        this.suspicious = suspicious;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public WalletEntity getWallet() {
        return wallet;
    }

    public void setWallet(WalletEntity wallet) {
        this.wallet = wallet;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Boolean getSuspicious() {
        return suspicious;
    }

    public void setSuspicious(Boolean suspicious) {
        this.suspicious = suspicious;
    }
}
