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

}
