package com.example.citygame.model.productionbuildings;

import com.example.citygame.model.economy.Balance;
import com.example.citygame.model.resources.Resource;
import com.example.citygame.model.workforce.Workforce;
import com.example.citygame.model.workforce.WorkforceType;

public class Fishery extends ProductionBuilding{

    public Fishery(){
        super("Fishery", WorkforceType.FARMER, 25, 40);

        Resource.FISH.increaseProductionRate(2d);
        Workforce.INSTANCE.decreaseWorkforce(WorkforceType.FARMER, 20);
        Balance.INSTANCE.addExpensePerMinute(40);
        Balance.INSTANCE.substractToBalance(100);
    }

}