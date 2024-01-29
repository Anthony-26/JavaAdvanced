package com.example.citygame.model;

public abstract class ProductionBuilding extends Building{ 

    private Citizen workforceType;
    private int workforce;
    private int cost;

    ProductionBuilding(String name, Citizen workforceType, int workforce, int cost){
        super(name);
        this.workforceType = workforceType;
        this.workforce = workforce;
        this.cost = cost;
    }

}
