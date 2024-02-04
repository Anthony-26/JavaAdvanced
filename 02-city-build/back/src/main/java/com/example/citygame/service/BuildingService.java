package com.example.citygame.service;

// import java.util.List;

import com.example.citygame.model.productionbuildings.ProductionBuilding;

public interface BuildingService {

    // <T extends ProductionBuilding> void addBuilding(T building);

    <T extends ProductionBuilding> T createBuilding(Class<T> buildingType) throws ReflectiveOperationException;

    // <T extends ProductionBuilding> List<ProductionBuilding> getAllBuildingWithType(Class<T> buildingType);

    void testingMethod();

    void voidEndpoint();

}
