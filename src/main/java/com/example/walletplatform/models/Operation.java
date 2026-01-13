package com.example.walletplatform.models;

import com.example.walletplatform.enums.Type;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

import java.time.LocalDateTime;

@Entity
@Table(name="operations")
public class Operation {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private Type type;

    @Column(nullable=false)
    @Min(0)
    private Double amount;

    @Column(nullable=false)
    private LocalDateTime timestamp;

    @Column(nullable=false)
    private Boolean suspicious;

    public Operation() {}

    public Operation(Type type, Double amount, LocalDateTime timestamp, Boolean suspicious) {
        this.type = type;
        this.amount = amount;
        this.timestamp = timestamp;
        this.suspicious = suspicious;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
