package com.example.walletplatform.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class CreateWalletRequest {

    @Pattern(regexp = "^WLT-[A-Za-z0-9]+$")
    @NotBlank
    private String walletCode;

    @Email
    @NotBlank
    private String ownerEmail;

    @Min(0)
    private Double balance;


    public String getWalletCode() {
        return walletCode;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public Double getBalance() {
        return balance;
    }
}
