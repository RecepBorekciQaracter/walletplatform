package com.example.walletplatform.controllers;

import com.example.walletplatform.entities.OperationEntity;
import com.example.walletplatform.entities.WalletEntity;
import com.example.walletplatform.models.CreateWalletRequest;
import com.example.walletplatform.services.WalletService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wallets")
public class WalletController {

    private final WalletService walletService;

    @Autowired
    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @PostMapping
    public WalletEntity createWallet(@Valid @RequestBody CreateWalletRequest request) {
        return walletService.createWallet(request);
    }

    @GetMapping("/{id}")
    public WalletEntity getWallet(@PathVariable Long id) {
        return walletService.getWallet(id);
    }

    @PostMapping("/{id}/add")
    public WalletEntity addFunds(@RequestParam Double amount, @PathVariable Long id) {
        return walletService.addFunds(id, amount);
    }

    @PostMapping("/{id}/spend")
    public WalletEntity spendFunds(@RequestParam Double amount, @PathVariable Long id) {
        return walletService.spendFunds(id, amount);
    }

    @GetMapping("/{id}/operations")
    public List<OperationEntity> getOperations(@PathVariable Long id) {
        return walletService.getOperations(id);
    }

}
