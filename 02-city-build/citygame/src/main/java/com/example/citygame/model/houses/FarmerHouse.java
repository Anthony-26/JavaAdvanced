package com.example.citygame.model.houses;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.example.citygame.model.economy.Balance;
import com.example.citygame.model.resources.Resource;
import com.example.citygame.model.workforce.Workforce;

public class FarmerHouse extends House {
    
    public static final Map<String, Double> resourceNeeds;
    static {
        Map<String, Double> aMap = new HashMap<>();
        aMap.put("Fish", 0.05);
        resourceNeeds = Collections.unmodifiableMap(aMap);
    }

    public FarmerHouse(){
        super("Farmer House", 10, 1);

        Workforce.INSTANCE.addOneFarmerWorkforce();
        Resource.FISH.increaseConsumptionRate(0.05d);
        Balance.INSTANCE.addRevenuePerMinute(super.getCurrentOccupants() * 5);
    }

}
