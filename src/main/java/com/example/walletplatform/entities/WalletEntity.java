package com.example.walletplatform.entities;

import jakarta.persistence.*;

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

    @OneToMany(mappedBy = "wallets", cascade = CascadeType.ALL)
    private List<OperationEntity> operations;
}
