package com.example.citygame.model.houses;

import java.util.HashMap;
import java.util.Map;

import com.example.citygame.model.economy.Balance;
import com.example.citygame.model.resources.Resource;
import com.example.citygame.model.workforce.Workforce;
import com.example.citygame.model.workforce.WorkforceType;

public class FarmerHouse extends House {

    private Map<String, Double> resourceFill = new HashMap<>();
    private Balance balance;
    private Workforce workforce;
    private Resource fish;

    public static final Map<String, Double> resourceNeeds = Map.of("Fish", 0.05);

    public FarmerHouse(Balance balance, Workforce workforce, Resource fish){
        super("Farmer House", 10, 1);
        this.balance = balance;
        this.workforce = workforce;
        this.fish = fish;
        this.resourceFill.put("Fish", 0.0d);

        fish.setQuantity(20d);
        workforce.increaseWorkforce(WorkforceType.FARMER, 2);
        fish.increaseConsumptionRate(0.05d);
        balance.addRevenuePerMinute(super.getCurrentOccupants() * 5);

        updatePeople();
    }

    public void updatePeople() {
        double fishQuantity = fish.getQuantity();
        if (fishQuantity > 1d) {
            if (resourceFill.get("Fish") < 0.05d) {
                resourceFill.compute("Fish", (key, oldValue) -> oldValue + 0.01d);
                workforce.increaseWorkforce(WorkforceType.FARMER, 2);
            }
        } else if (fishQuantity < 1) {
            if (resourceFill.get("Fish") > 0d) {
                resourceFill.compute("Fish", (key, oldValue) -> oldValue - 0.01d);
                workforce.decreaseWorkforce(WorkforceType.FARMER, 2);
            }
        }
        System.out.println("Fish quantity : " + fishQuantity + ".\nRessourceFill Fish : " + resourceFill.get("Fish")
                + ".\nTotal Workforce (Farmers) : " + workforce.getFarmerWorkforce());
    }

}