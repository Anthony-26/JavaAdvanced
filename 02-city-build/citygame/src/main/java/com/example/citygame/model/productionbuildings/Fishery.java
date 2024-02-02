package com.example.citygame.model.productionbuildings;

import com.example.citygame.model.economy.Balance;
import com.example.citygame.model.resources.Resource;
import com.example.citygame.model.workforce.Workforce;
import com.example.citygame.model.workforce.WorkforceType;

public class Fishery extends ProductionBuilding {

    private Balance balance;
    private Workforce workforce;
    private Resource fish;

    public Fishery(Balance balance, Workforce workforce, Resource fish) {
        super("Fishery", WorkforceType.FARMER, 25, 40);
        this.balance = balance;
        this.workforce = workforce;
        this.fish = fish;

        workforce.decreaseWorkforce(WorkforceType.FARMER, 20);
        balance.addExpensePerMinute(40);
        balance.substractToBalance(100);
        fish.increaseProductionRate(2d);
    }
}