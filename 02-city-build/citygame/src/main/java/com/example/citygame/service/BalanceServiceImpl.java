package com.example.citygame.service;

import org.springframework.stereotype.Service;

import com.example.citygame.model.economy.Balance;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BalanceServiceImpl implements BalanceService {

    private final Balance balance;

    @Override
    public int getCurrentBalance() {
        return balance.getCurrentBalance();
    }

    @Override
    public void addToBalance(int amount) {
        balance.addToBalance(amount);
    }

    @Override
    public void substractToBalance(int amount) {
        balance.substractToBalance(amount);
    }

    @Override
    public void addRevenuePerMinute(int amount) {
        balance.addRevenuePerMinute(amount);
    }

    @Override
    public void addExpensePerMinute(int amount) {
        balance.addExpensePerMinute(amount);
    }
}