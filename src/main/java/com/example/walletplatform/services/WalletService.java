package com.example.walletplatform.services;

import com.example.walletplatform.entities.OperationEntity;
import com.example.walletplatform.entities.WalletEntity;
import com.example.walletplatform.models.CreateWalletRequest;
import com.example.walletplatform.models.Wallet;
import com.example.walletplatform.repositories.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalletService {
    private final WalletRepository walletRepository;
    private Long nextId = 1L;

    @Autowired
    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    WalletEntity createWallet(CreateWalletRequest request) {
        WalletEntity walletEntity = new WalletEntity(request.getOwnerEmail(), request.getWalletCode(), request.getBalance());

        walletEntity.setId(this.nextId++);

        return walletRepository.save(walletEntity);
    }

    WalletEntity getWallet(Long id) {
        return walletRepository.findById(id).orElse(null);
    }

    WalletEntity addFunds(Long id, Double amount) {
        WalletEntity walletEntity = getWallet(id);

        walletEntity.addFunds(amount);

        return walletRepository.save(walletEntity);
    }

    WalletEntity spendFunds(Long id, Double amount) {
        WalletEntity walletEntity = getWallet(id);
        walletEntity.spendFunds(amount);
        return walletRepository.save(walletEntity);
    }

    List<OperationEntity> getOperations(Long id) {
        WalletEntity walletEntity = getWallet(id);

        return walletEntity.getOperations();
    }


}
