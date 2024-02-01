package com.example.citygame.service;

import org.springframework.stereotype.Service;

@Service
public class BalanceServiceImpl implements BalanceService {
    private int balance = 0;

    @Override
    public int getCurrentBalance() {
        return balance;
    }

    @Override
    public void addFunds(int amount) {
        balance += amount;
    }

    @Override
    public void deductFunds(int amount) {
        balance -= amount;
    }
}