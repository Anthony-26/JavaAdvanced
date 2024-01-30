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

}
