package com.example.walletplatform.models;

import com.example.walletplatform.enums.Type;
import jakarta.validation.constraints.*;

import java.util.Comparator;
import java.util.List;

public class Wallet {
    private Long id;
    private String ownerEmail;
    private String walletCode;
    private Double balance;
    private List<Operation> operations;
}
