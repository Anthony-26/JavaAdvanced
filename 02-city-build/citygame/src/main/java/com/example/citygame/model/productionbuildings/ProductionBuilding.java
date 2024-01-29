package com.example.citygame.model.productionbuildings;

import com.example.citygame.model.Building;
import com.example.citygame.model.citizens.Citizen;

public abstract class ProductionBuilding extends Building{ 

    private Citizen workforceType;
    private int workforce;
    private int cost;

    protected ProductionBuilding(String name, Citizen workforceType, int workforce, int cost){
        super(name);
        this.workforceType = workforceType;
        this.workforce = workforce;
        this.cost = cost;
    }

}
