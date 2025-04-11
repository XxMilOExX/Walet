package com.example.TestWallet.service;

import com.example.TestWallet.ex.InsufficientFundsException;
import com.example.TestWallet.ex.WalletNotFoundException;
import com.example.TestWallet.model.Wallet;
import com.example.TestWallet.model.WalletOperationRequest;
import com.example.TestWallet.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.UUID;

@Service
@Transactional
public class WalletService {
    @Autowired
    private WalletRepository walletRepository;


    public Wallet updateBalance(WalletOperationRequest request){
        Wallet wallet = walletRepository.findByWalletId(request.getWalletId())
                .orElseThrow(() -> new WalletNotFoundException("Wallet not found"));
        switch (request.getOperationType()) {
            case DEPOSIT:
                wallet.setBalance(wallet.getBalance().add(request.getAmount()));
                break;
            case WITHDRAW:
                if (wallet.getBalance().compareTo(request.getAmount()) < 0) {
                    throw new InsufficientFundsException("Insufficient funds");
                }
                wallet.setBalance(wallet.getBalance().subtract(request.getAmount()));
                break;
        }

        return walletRepository.save(wallet);
    }
    public BigDecimal getBalance(UUID walletId) {
        Wallet wallet = walletRepository.findByWalletId(walletId)
                .orElseThrow(() -> new WalletNotFoundException("Wallet not found"));
        return wallet.getBalance();
    }
}
