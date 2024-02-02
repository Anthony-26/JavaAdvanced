package com.example.citygame.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.citygame.model.economy.Balance;
import com.example.citygame.model.productionbuildings.Fishery;
import com.example.citygame.model.productionbuildings.ProductionBuilding;
import com.example.citygame.model.resources.Resource;
import com.example.citygame.model.workforce.Workforce;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BuildingServiceImpl implements BuildingService {
    
    private final Map<Class<? extends ProductionBuilding>, List<ProductionBuilding>> buildingsMap = new HashMap<>();
    private final Balance balance;
    private final Workforce workforce;
    private final Resource resource;

    @Override
    public void createFishery(){
        Fishery fishery = new Fishery(balance, workforce, resource);
        fisheryList.add(fishery);
        System.out.println(fishery);
    }

    @Override
    public <T extends ProductionBuilding> void addBuilding(T building){
        List<ProductionBuilding> buildings = buildingsMap.computeIfAbsent(building.getClass(), k -> new ArrayList<>());
        buildings.add(building);
    }

}
