package com.example.citygame.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.citygame.service.BalanceService;

@RestController
@RequestMapping("/api/economy")
public class EconomyController {

    private final BalanceService balanceService;

    @Autowired
    public EconomyController(BalanceService balanceService) {
        this.balanceService = balanceService;
    }

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