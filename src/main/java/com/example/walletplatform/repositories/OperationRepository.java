package com.example.walletplatform.repositories;

import com.example.walletplatform.entities.OperationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository extends JpaRepository<OperationEntity, Long> {
}
