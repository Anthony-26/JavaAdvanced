package com.example.citygame.model;

public class FishingHut extends ProductionBuilding{

    private Resource fish;

    FishingHut(String name, Citizen workforceType, int workforce, int cost, Resource fish){
        super(name, workforceType, workforce, cost);
        this.fish = fish;
    }

}
