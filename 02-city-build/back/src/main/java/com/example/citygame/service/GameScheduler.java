package com.example.citygame.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.citygame.managers.FarmerHouseManager;
import com.example.citygame.managers.ProductionBuildingManager;
import com.example.citygame.managers.ResourceManager;
import com.example.citygame.model.Building;
import com.example.citygame.model.economy.Balance;
import com.example.citygame.model.productionbuildings.Fishery;
import com.example.citygame.model.productionbuildings.ProductionBuilding;
import com.example.citygame.model.workforce.Workforce;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GameScheduler {

    private final Balance balance;
    private final Workforce workforce;
    private final FarmerHouseManager farmerHouseManager;
    private final ResourceManager resourceManager;
    private final ProductionBuildingManager productionBuildingManager;

    @Scheduled(fixedRate = 15000)
    public void updateGame() throws ClassNotFoundException {

        balance.updateBalance();
        resourceManager.updateResource();
        farmerHouseManager.updateOccupants();

        System.out.println("""
                Game recap :

                    Total buildings : %d

                        Number of fishery : %d
                        Number of Farmer House : %d

                    Current Balance : %d

                        Total expense per min : %d
                        Total revenue per min : %d

                    Workforce : %d People

                        Farmers : %d

                    Fish quantity : %,.2f

                        Production Rate : %,.2f
                        Consumption Rate : %,.2f

                """.formatted(
                Building.idCounter,
                productionBuildingManager.getNumberOfBuilding(Fishery.class),
                farmerHouseManager.mapSize(),
                balance.getCurrentBalance(),
                balance.getExpensesPerMinute(),
                balance.getRevenuesPerMinute(),
                workforce.getTotalWorkforce(),
                workforce.getFarmerWorkforce(),
                resourceManager.getResource("Fish").getQuantity(),
                resourceManager.getResource("Fish").getProductionRate(),
                resourceManager.getResource("Fish").getConsumptionRate()));

    }
}