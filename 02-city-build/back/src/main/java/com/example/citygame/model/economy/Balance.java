package com.example.citygame.model.economy;

import org.springframework.stereotype.Component;

@Component
public class Balance {

    private int currentBalance;
    private int revenuesPerMinute;
    private int expensesPerMinute;

    public Balance() {
        this.currentBalance = 75000;
        this.revenuesPerMinute = 0;
        this.expensesPerMinute = 0;
    }

    public int getCurrentBalance() {
        return this.currentBalance;
    }

    public int getRevenuesPerMinute() {
        return this.revenuesPerMinute;
    }

    public int getExpensesPerMinute() {
        return this.expensesPerMinute;
    }

    public void updateBalance() {
        this.currentBalance += revenuesPerMinute - expensesPerMinute;
    }

    public void addRevenuePerMinute(int amount) {
        this.revenuesPerMinute += amount;
    }

    public void substractRevenuePerMinute(int amount) {
        this.revenuesPerMinute -= amount;
    }

    public void addExpensePerMinute(int amount) {
        this.expensesPerMinute += amount;
    }

    public void addToBalance(int amount){
        this.currentBalance += amount;
    }

    public void substractToBalance(int amount){
        this.currentBalance -= amount;
    }

}
