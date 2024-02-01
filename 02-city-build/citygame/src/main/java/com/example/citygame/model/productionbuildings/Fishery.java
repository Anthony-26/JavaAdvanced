package com.example.citygame.model.productionbuildings;

import com.example.citygame.model.economy.Balance;
import com.example.citygame.model.resources.Resource;
import com.example.citygame.model.workforce.Workforce;
import com.example.citygame.model.workforce.WorkforceType;

public class Fishery extends ProductionBuilding {

    private Balance balance;

    public Fishery(Balance balance) {
        super("Fishery", WorkforceType.FARMER, 25, 40);
        this.balance = balance;
    }

    public void init() {
        Resource.FISH.increaseProductionRate(2d);
        Workforce.INSTANCE.decreaseWorkforce(WorkforceType.FARMER, 20);
        balance.addExpensePerMinute(40);
        balance.substractToBalance(100);
    }

}