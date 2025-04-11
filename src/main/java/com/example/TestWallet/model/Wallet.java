package com.example.TestWallet.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity
@Table(name = "wallets")
public class Wallet {
    @Id
    private UUID walletId;

    @Column(nullable = false)
    private BigDecimal balance;

    public UUID getWalletId() {
        return walletId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setWalletId(UUID walletId) {
        this.walletId = walletId;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
