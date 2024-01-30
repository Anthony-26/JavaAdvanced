package com.example.citygame.model.houses;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.example.citygame.model.resources.Resource;

public class FarmerHouse extends House {
    
    public static final Map<String, Double> resourceNeeds;
    static {
        Map<String, Double> aMap = new HashMap<>();
        aMap.put("Fish", 0.05);
        resourceNeeds = Collections.unmodifiableMap(aMap);
    }

    public FarmerHouse(){
        super("Farmer House", 10, 1);
        Resource.FISH.increaseConsumptionRate(0.05d);
    }

}
