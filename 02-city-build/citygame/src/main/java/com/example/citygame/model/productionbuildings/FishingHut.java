package com.example.citygame.model.productionbuildings;

import com.example.citygame.model.citizens.Citizen;
import com.example.citygame.model.resources.Fish;

public class FishingHut extends ProductionBuilding{

    FishingHut(String name, Citizen workforceType, int workforce, int cost, Fish fish){
        super(name, workforceType, workforce, cost);

        fish.increaseProductionRate(50);
    }



}