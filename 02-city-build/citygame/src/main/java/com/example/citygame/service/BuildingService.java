package com.example.citygame.service;

import com.example.citygame.model.productionbuildings.ProductionBuilding;

public interface BuildingService {
    
    void createFishery();
    <T extends ProductionBuilding> void addBuilding(T building);

}
