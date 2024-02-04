package com.example.citygame.service;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.citygame.managers.FarmerHouseManager;
import com.example.citygame.managers.ResourceManager;
import com.example.citygame.model.economy.Balance;
import com.example.citygame.model.houses.FarmerHouse;
import com.example.citygame.model.productionbuildings.ProductionBuilding;
import com.example.citygame.model.workforce.Workforce;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BuildingServiceImpl implements BuildingService {

    private final Map<Class<? extends ProductionBuilding>, List<ProductionBuilding>> buildingsMap = new HashMap<>();
    private final Balance balance;
    private final Workforce workforce;
    private final ResourceManager resourceManager;
    private final FarmerHouseManager farmerHouseManager;

    @Override
    public <T extends ProductionBuilding> void addBuilding(T building) {
        List<ProductionBuilding> buildings = buildingsMap.computeIfAbsent(building.getClass(), k -> new ArrayList<>());
        buildings.add(building);
    }

    @Override
    public <T extends ProductionBuilding> T createBuilding(Class<T> buildingType) throws ReflectiveOperationException {
        Constructor<T> constructor = buildingType.getConstructor(Balance.class, Workforce.class, ResourceManager.class);
        T building = constructor.newInstance(balance, workforce, resourceManager);
        addBuilding(building);
        return building;
    }

    @Override
    public <T extends ProductionBuilding> List<ProductionBuilding> getAllBuildingWithType(Class<T> buildingType) {
            return buildingsMap.get(buildingType);
    }

    @Override
    public void testingMethod(){
        FarmerHouse fh = new FarmerHouse(balance, workforce, resourceManager);
        farmerHouseManager.addFarmerHouseInMap(fh);
        farmerHouseManager.updateOccupants();
    }

    @Override
    public void voidEndpoint(){
        System.out.println("Void");
    }

}
