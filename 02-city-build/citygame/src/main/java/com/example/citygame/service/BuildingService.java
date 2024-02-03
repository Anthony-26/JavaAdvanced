package com.example.citygame.service;

import com.example.citygame.model.productionbuildings.ProductionBuilding;

public interface BuildingService {
    
    <T extends ProductionBuilding> void addBuilding(T building);
    <T extends ProductionBuilding> T createBuilding(Class<T> buildingType) throws ReflectiveOperationException;

}
