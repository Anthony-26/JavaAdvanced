package com.example.citygame.service;

public interface BalanceService {
    int getCurrentBalance();
    void addToBalance(int amount);
    void substractToBalance(int amount);
    void addRevenuePerMinute(int amount);   
    void addExpensePerMinute(int amount);   
    
}