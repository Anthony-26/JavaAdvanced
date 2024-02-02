package com.example.citygame.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.citygame.model.economy.Balance;
import com.example.citygame.model.productionbuildings.Fishery;
import com.example.citygame.model.resources.Resource;
import com.example.citygame.model.workforce.Workforce;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BuildingServiceImpl implements BuildingService {
    
    private final List<Fishery> fisheryList = new ArrayList<>();
    private final Balance balance;
    private final Workforce workforce;
    private final Resource resource;

    @Override
    public void createFishery(){
        Fishery fishery = new Fishery(balance, workforce, resource);
        fisheryList.add(fishery);
        System.out.println(fishery);
    }
}
