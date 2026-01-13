package com.example.walletplatform.entities;

import com.example.walletplatform.enums.Type;
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
}
