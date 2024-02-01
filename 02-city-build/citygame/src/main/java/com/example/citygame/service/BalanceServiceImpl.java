package com.example.citygame.service;

import org.springframework.stereotype.Service;

import com.example.citygame.model.economy.Balance;

@Service
public class BalanceServiceImpl implements BalanceService {

    @Override
    public int getCurrentBalance() {
        return Balance.INSTANCE.getCurrentBalance();
    }

    @Override
    public void addToBalance(int amount) {
        Balance.INSTANCE.addToBalance(amount);
    }

    @Override
    public void substractToBalance(int amount) {
        Balance.INSTANCE.substractToBalance(amount);
    }
}