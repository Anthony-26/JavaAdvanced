package com.example.citygame.model.houses;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.example.citygame.model.economy.Balance;
import com.example.citygame.model.resources.Resource;
import com.example.citygame.model.workforce.Workforce;

public class FarmerHouse extends House {

    private Balance balance;
    private Workforce workforce;
    private Resource fish;
    
    public static final Map<String, Double> resourceNeeds = Map.of("Fish", 0.05);

    public FarmerHouse(Balance balance, Workforce workforce, Resource fish){
        super("Farmer House", 10, 1);
        this.balance = balance;
        this.workforce = workforce;
        this.fish = fish;

        workforce.addOneFarmerWorkforce();
        fish.increaseConsumptionRate(0.05d);
        balance.addRevenuePerMinute(super.getCurrentOccupants() * 5);
    }

}