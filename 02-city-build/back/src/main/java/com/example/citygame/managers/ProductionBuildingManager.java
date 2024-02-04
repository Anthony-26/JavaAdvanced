package com.example.citygame.managers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.example.citygame.model.economy.Balance;
import com.example.citygame.model.productionbuildings.Fishery;
import com.example.citygame.model.productionbuildings.ProductionBuilding;
import com.example.citygame.model.workforce.Workforce;

import lombok.RequiredArgsConstructor;

@Component
public class ProductionBuildingManager {

    private final Map<Class<? extends ProductionBuilding>, List<ProductionBuilding>> buildingsMap = new HashMap<>();

    private final Balance balance;
    private final Workforce workforce;
    private final ResourceManager resourceManager;

    public ProductionBuildingManager(Balance balance, Workforce workforce, ResourceManager resourceManager) {
        this.balance = balance;
        this.workforce = workforce;
        this.resourceManager = resourceManager;

        buildingsMap.put(Fishery.class, new ArrayList<>());
    }

    public <T extends ProductionBuilding> void addBuilding(T building) {
        List<ProductionBuilding> buildingList = buildingsMap.get(building.getClass());
        buildingList.add(building);
    }

    public <T extends ProductionBuilding> int getNumberOfBuilding(Class<T> buildingType) {
        return buildingsMap.get(buildingType).size();
    }

}
