package com.example.citygame;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.citygame.model.economy.Balance;

@Component
public class GameScheduler {

    @Scheduled(fixedRate = 10000) 
    public void updateGame() {

        // Balance.INSTANCE.updateBalance();

    }
}