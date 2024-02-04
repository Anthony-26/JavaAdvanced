package com.example.citygame.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.citygame.model.economy.Balance;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GameScheduler {

    private final Balance balance;
    

    @Scheduled(fixedRate = 10000) 
    public void updateGame() {

        balance.updateBalance();


    }
}