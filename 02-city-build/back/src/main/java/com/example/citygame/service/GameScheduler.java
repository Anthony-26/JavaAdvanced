package com.example.citygame.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.citygame.managers.FarmerHouseManager;
import com.example.citygame.model.economy.Balance;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GameScheduler {

    private final Balance balance;
    private final FarmerHouseManager farmerHouseManager;

    @Scheduled(fixedRate = 30000)
    public void updateGame() {

        balance.updateBalance();
        farmerHouseManager.updateOccupants();

    }
}