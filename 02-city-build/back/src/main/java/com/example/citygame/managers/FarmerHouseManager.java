package com.example.citygame.managers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.example.citygame.model.economy.Balance;
import com.example.citygame.model.houses.FarmerHouse;
import com.example.citygame.model.resources.Resource;
import com.example.citygame.model.workforce.Workforce;
import com.example.citygame.model.workforce.WorkforceType;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FarmerHouseManager {

    private Map<Integer, FarmerHouse> farmerHouseMap = new HashMap<>();

    private final ResourceManager resourceManager;
    private final Workforce workforce;
    private final Balance balance;

    public static final Map<String, Double> farmerResourceNeeds = Map.of("Fish", 0.05);

    public void updateOccupants() {
        farmerHouseMap.forEach((id, farmerHouse) -> {

            farmerResourceNeeds.forEach((resourceName, need) -> {
                Map<String, Double> farmerResourceFill = farmerHouse.getResourceFill();

                Double currentFill = farmerResourceFill.get(resourceName);
                Resource resource = resourceManager.getResource(resourceName);

                double resourceQuantity = resource.getQuantity();

                if (resourceQuantity > 1 && currentFill < need) {
                    farmerResourceFill.put(resourceName, Math.min(need, currentFill + 0.01d));
                    workforce.increaseWorkforce(WorkforceType.FARMER, 2);
                    balance.addRevenuePerMinute(10);
                } else if (resourceQuantity < 1 && currentFill > 0d) {
                    farmerResourceFill.put(resourceName, Math.max(0, currentFill - 0.01d));
                    workforce.decreaseWorkforce(WorkforceType.FARMER, 2);
                    balance.substractRevenuePerMinute(10);
                    ;
                }
            });

        });

    }

    public void addFarmerHouseInMap(FarmerHouse farmerHouse) {
        this.farmerHouseMap.put(farmerHouse.getId(), farmerHouse);
    }

    public int mapSize() {
        return this.farmerHouseMap.size();
    }

}
