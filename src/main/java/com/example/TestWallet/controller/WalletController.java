package com.example.TestWallet.controller;

import com.example.TestWallet.model.WalletOperationRequest;
import com.example.TestWallet.service.WalletService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/wallets")
public class WalletController {

    @Autowired
    private WalletService walletService;

    @PostMapping
    public ResponseEntity<Void> updateBalance(@Valid @RequestBody WalletOperationRequest request) {
        walletService.updateBalance(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{walletId}")
    public ResponseEntity<BigDecimal> getBalance(@PathVariable UUID walletId) {
        BigDecimal balance = walletService.getBalance(walletId);
        return ResponseEntity.ok(balance);
    }
}