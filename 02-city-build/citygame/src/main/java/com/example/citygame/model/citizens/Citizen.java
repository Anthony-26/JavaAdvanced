package com.example.citygame.model.citizens;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Citizen {
    
    private int totalPopulation;
    private Map<CitizenType, Integer> workforce;
    
    public Citizen(){
        this.totalPopulation = 0;

        this.workforce = new HashMap<>();
        this.workforce.put(CitizenType.FARMER, 0);
    }

    public int getTotalPopulation(){
        return totalPopulation;
    }

    public Map<CitizenType, Integer> getWorkforce(){
        return Collections.unmodifiableMap(this.workforce);
    }

    public void increaseTotalPopulationByOne(){
        totalPopulation += 1;
    }

    public void decreaseTotalPopulationByOne(){
        totalPopulation -= 1;
    }

    public int getFarmerWorkforce() {
        return this.getWorkforce().get(CitizenType.FARMER);
    }

    public void addOneFarmerWorkforce() {
        this.getWorkforce().merge(CitizenType.FARMER, 1, Integer::sum);
        this.increaseTotalPopulationByOne();
    }

    public void removeOneFarmerWorkforce() {
        if (this.getWorkforce().get(CitizenType.FARMER) > 0) {
            this.getWorkforce().merge(CitizenType.FARMER, 0, (oldValue, value) -> oldValue--);
            this.decreaseTotalPopulationByOne();
        }
    }
}