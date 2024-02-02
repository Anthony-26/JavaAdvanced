package com.example.citygame.model.productionbuildings;

import java.util.Map;

import com.example.citygame.model.Building;
import com.example.citygame.model.resources.Resource;
import com.example.citygame.model.workforce.WorkforceType;

public abstract class ProductionBuilding extends Building{ 

    private WorkforceType workforceType;
    private int workforce;
    private int maintenanceCost;
    private Map<Resource, Integer> constructionCost;

    protected ProductionBuilding(String name, WorkforceType workforceType, int workforce, int maintenanceCost){
        super(name);
        this.workforceType = workforceType;
        this.workforce = workforce;
        this.maintenanceCost = maintenanceCost;
    }

    public WorkforceType getWorkforceType() {
        return this.workforceType;
    }

    public void setWorkforceType(WorkforceType workforceType) {
        this.workforceType = workforceType;
    }

    public int getWorkforce() {
        return this.workforce;
    }

    public void setWorkforce(int workforce) {
        this.workforce = workforce;
    }

    public int getMaintenanceCost() {
        return this.maintenanceCost;
    }

    public void setMaintenanceCost(int maintenanceCost) {
        this.maintenanceCost = maintenanceCost;
    }

    public Map<Resource,Integer> getConstructionCost() {
        return this.constructionCost;
    }

    public void setConstructionCost(Map<Resource,Integer> constructionCost) {
        this.constructionCost = constructionCost;
    }


}
