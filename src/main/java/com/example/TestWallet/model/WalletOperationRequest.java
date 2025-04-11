package com.example.TestWallet.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;


@Setter
@Getter
public class WalletOperationRequest {
    private UUID walletId;
    private OperationType operationType;
    private BigDecimal amount;

    public UUID getWalletId() {
        return walletId;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setWalletId(UUID walletId) {
        this.walletId = walletId;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}

