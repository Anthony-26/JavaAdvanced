package com.example.citygame.model.houses;

import java.util.HashMap;
import java.util.Map;

import com.example.citygame.managers.ResourceManager;
import com.example.citygame.model.economy.Balance;
import com.example.citygame.model.workforce.Workforce;
import com.example.citygame.model.workforce.WorkforceType;

public class FarmerHouse extends House {

    private Map<String, Double> resourceFill = new HashMap<>();
    private Balance balance;
    private Workforce workforce;
    private ResourceManager resourceManager;

    public FarmerHouse(Balance balance, Workforce workforce, ResourceManager resourceManager) {
        super("Farmer House", 10, 2);
        this.balance = balance;
        this.workforce = workforce;
        this.resourceManager = resourceManager;

        this.resourceFill.put("Fish", 0.0d);

        this.workforce.increaseWorkforce(WorkforceType.FARMER, 2);
        this.resourceManager.getResource("Fish").increaseConsumptionRate(0.05d);
        this.balance.addRevenuePerMinute(super.getCurrentOccupants() * 5);
    }

    public Map<String, Double> getResourceFill(){
        return this.resourceFill;
    }

}