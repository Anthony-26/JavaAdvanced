package com.example.citygame.model.houses;

import java.util.HashMap;
import java.util.Map;

import com.example.citygame.model.Building;
import com.example.citygame.model.resources.Resource;

public abstract class House extends Building {

    private int maxCapacity;
    private int currentOccupants;
    private Map<Resource, Double> resourceNeeds;

    public House(String name, int maxCapacity, int currentOccupants){
        super(name);
        this.maxCapacity = maxCapacity;
        this.currentOccupants = currentOccupants;
        this.resourceNeeds = new HashMap<>();
    }

    public int getMaxCapacity() {
        return this.maxCapacity;
    }

    public int getCurrentOccupants() {
        return this.currentOccupants;
    }

    public void addOneOccupant(){
        if (currentOccupants < maxCapacity)
            this.currentOccupants += 1;
    }

    public void removeOneOccupant(){
        if(currentOccupants > 0)
            this.currentOccupants -= 1;
    }

    public Map<Resource, Double> getResourceNeeds() {
        return this.resourceNeeds;
    }


}