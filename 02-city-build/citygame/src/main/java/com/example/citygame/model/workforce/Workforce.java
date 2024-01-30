package com.example.citygame.model.workforce;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Workforce {
    
    private int totalPopulation;
    private Map<WorkforceType, Integer> workforceList;
    
    public Workforce(){
        this.totalPopulation = 0;

        this.workforceList = new HashMap<>();
        this.workforceList.put(WorkforceType.FARMER, 0);
    }

    public int getTotalPopulation(){
        return totalPopulation;
    }

    public Map<WorkforceType, Integer> getWorkforceList(){
        return Collections.unmodifiableMap(this.workforceList);
    }

    public void increaseTotalPopulationByOne(){
        totalPopulation += 1;
    }

    public void decreaseTotalPopulationByOne(){
        totalPopulation -= 1;
    }

    public int getFarmerWorkforce() {
        return this.getWorkforceList().get(WorkforceType.FARMER);
    }

    public void addOneFarmerWorkforce() {
        this.getWorkforceList().merge(WorkforceType.FARMER, 1, Integer::sum);
        this.increaseTotalPopulationByOne();
    }

    public void removeOneFarmerWorkforce() {
        if (this.getWorkforceList().get(WorkforceType.FARMER) > 0) {
            this.getWorkforceList().merge(WorkforceType.FARMER, 0, (oldValue, value) -> oldValue--);
            this.decreaseTotalPopulationByOne();
        }
    }
}