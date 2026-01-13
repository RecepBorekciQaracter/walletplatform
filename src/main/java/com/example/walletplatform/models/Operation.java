package com.example.walletplatform.models;

import com.example.walletplatform.enums.Type;
import jakarta.validation.constraints.Min;

import java.time.LocalDateTime;

public class Operation {
    private Long id;
    private Wallet wallet;

    private Type type;

    @Min(0)
    private Double amount;

    private LocalDateTime timestamp;

    private Boolean suspicious;

    public Operation() {}

    public Operation(Type type, Double amount, Boolean suspicious) {
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
