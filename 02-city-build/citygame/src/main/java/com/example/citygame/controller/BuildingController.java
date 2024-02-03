package com.example.citygame.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.citygame.model.productionbuildings.ProductionBuilding;
import com.example.citygame.service.BuildingService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/buildings")
@RequiredArgsConstructor
public class BuildingController {
    
    private final BuildingService buildingService;
    
    @PostMapping("/create")
    public ResponseEntity<ProductionBuilding> postMethodName(@RequestParam String buildingType) throws ReflectiveOperationException {
        String fullyQualifiedName = "com.example.citygame.model.productionbuildings.";
        Class<? extends ProductionBuilding> buildingClass = (Class<? extends ProductionBuilding>) Class.forName(fullyQualifiedName  + buildingType);
        ProductionBuilding newBuilding = buildingService.createBuilding(buildingClass);
        return new ResponseEntity<>(newBuilding, HttpStatus.OK);
    }
    
    

}
