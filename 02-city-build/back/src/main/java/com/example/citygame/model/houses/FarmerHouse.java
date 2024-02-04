package com.example.citygame.model.houses;

import java.util.HashMap;
import java.util.Map;

import com.example.citygame.managers.ResourceManager;
import com.example.citygame.model.economy.Balance;
import com.example.citygame.model.resources.Resource;
import com.example.citygame.model.workforce.Workforce;
import com.example.citygame.model.workforce.WorkforceType;

public class FarmerHouse extends House {

    private Map<String, Double> resourceFill = new HashMap<>();
    private Balance balance;
    private Workforce workforce;
    private ResourceManager resourceManager;

    public static final Map<String, Double> resourceNeeds = Map.of("Fish", 0.05);

    public FarmerHouse(Balance balance, Workforce workforce, ResourceManager resourceManager) {
        super("Farmer House", 10, 2);
        this.balance = balance;
        this.workforce = workforce;
        this.resourceManager = resourceManager;

        this.resourceFill.put("Fish", 0.0d);

        workforce.increaseWorkforce(WorkforceType.FARMER, 2);
        resourceManager.getResource("Fish").increaseConsumptionRate(0.05d);
        balance.addRevenuePerMinute(super.getCurrentOccupants() * 5);
    }

    public void updatePeople() {

        resourceNeeds.forEach((resourceName, need) -> {

            Double currentFill = resourceFill.get(resourceName);
            Resource resource = resourceManager.getResource(resourceName);

            double resourceQuantity = resource.getQuantity();

            if (resourceQuantity > 1 && currentFill < need) {
                resourceFill.put(resourceName, Math.min(need, currentFill + 0.01d));
                workforce.increaseWorkforce(WorkforceType.FARMER, 2);
                balance.addRevenuePerMinute(10);
            } else if (resourceQuantity < 1 && currentFill > 0d) {
                resourceFill.put(resourceName, Math.max(0, currentFill - 0.01d));
                workforce.decreaseWorkforce(WorkforceType.FARMER, 2);
                balance.substractRevenuePerMinute(10);
                ;
            }

        });
    }

}