package com.example.citygame.model.workforce;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class Workforce {

    private int totalWorkforce;
    private Map<WorkforceType, Integer> workforceList;
    
    private Workforce(){
        this.totalWorkforce = 0;

        this.workforceList = new HashMap<>();
        this.workforceList.put(WorkforceType.FARMER, 0);
    }

    public int getTotalWorkforce(){
        return totalWorkforce;
    }

    public Map<WorkforceType, Integer> getWorkforceList(){
        return Collections.unmodifiableMap(this.workforceList);
    }

    public void increaseTotalWorkforceByOne(){
        totalWorkforce += 1;
    }

    public void decreaseTotalWorkforceByOne(){
        totalWorkforce -= 1;
    }

    public void decreaseWorkforce(WorkforceType type, int workforce){
        this.workforceList.compute(type, (key, oldValue) -> oldValue - workforce);
    }

    public int getFarmerWorkforce() {
        return this.getWorkforceList().get(WorkforceType.FARMER);
    }

    public void addOneFarmerWorkforce() {
        this.workforceList.compute(WorkforceType.FARMER, (key, oldValue) -> oldValue++);
        this.increaseTotalWorkforceByOne();
    }

    public void removeOneFarmerWorkforce() {
        if (this.getWorkforceList().get(WorkforceType.FARMER) > 0) {
            this.workforceList.compute(WorkforceType.FARMER, (key, oldValue) -> oldValue--);
            this.decreaseTotalWorkforceByOne();
        }
    }
}