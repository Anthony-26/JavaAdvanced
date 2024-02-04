package com.example.citygame.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.citygame.service.EconomyService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/economy")
@RequiredArgsConstructor
public class EconomyController {

    private final EconomyService economyService;

    @GetMapping("/balance")
    public ResponseEntity<Integer> getCurrentBalance() {
        int currentBalance = economyService.getCurrentBalance();
        return new ResponseEntity<>(currentBalance, HttpStatus.OK);
    }
    
}