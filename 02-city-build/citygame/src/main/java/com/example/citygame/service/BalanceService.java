package com.example.citygame.service;

public interface BalanceService {
    int getCurrentBalance();
    void addFunds(int amount);
    void deductFunds(int amount);
    
}

