package com.example.TestWallet.repository;

import com.example.TestWallet.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface WalletRepository extends JpaRepository<Wallet, UUID> {
    Optional<Wallet> findByWalletId(UUID walletId);
}
