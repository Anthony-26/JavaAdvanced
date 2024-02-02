package com.example.citygame.service;

import org.springframework.stereotype.Service;

import com.example.citygame.model.economy.Balance;
import com.example.citygame.model.productionbuildings.Fishery;
import com.example.citygame.model.resources.Resource;
import com.example.citygame.model.workforce.Workforce;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BuildingServiceImpl implements BuildingService {
    
    private final Balance balance;
    private final Workforce workforce;
    private final Resource resource;

    @Override
    public void createFishery(){
        Fishery f = new Fishery(balance, workforce, resource);
        System.out.println(f);
    }
}
