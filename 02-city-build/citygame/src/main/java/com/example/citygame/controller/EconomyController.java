package com.example.citygame.controller;

import org.springframework.web.bind.annotation.*;

import com.example.citygame.model.economy.Balance;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/economy")
@RequiredArgsConstructor
public class EconomyController {

    private final BalanceService balanceService;

    // @GetMapping("/balance")
    // public ResponseEntity<Integer> getCurrentBalance() {
    //     int currentBalance = balanceService.getCurrentBalance();
    //     return new ResponseEntity<>(currentBalance, HttpStatus.OK);
    // }

    // @PostMapping("/transaction")
    // public ResponseEntity<Void> postTransaction(@RequestBody Transaction transaction) {
    //     boolean success = balanceService.applyTransaction(transaction);
        
    //     if (success) {
    //         return new ResponseEntity<>(HttpStatus.OK);
    //     } else {
    //         return new ResponseEntity<>(HttpStatus.CONFLICT);
    //     }
    // }

}