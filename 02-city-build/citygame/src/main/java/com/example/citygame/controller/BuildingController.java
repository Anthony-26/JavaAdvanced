package com.example.citygame.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.citygame.model.productionbuildings.ProductionBuilding;
import com.example.citygame.service.BuildingService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/buildings")
@RequiredArgsConstructor
public class BuildingController {
    
    private final BuildingService buildingService;

    @PostMapping("/fishery")
    public ResponseEntity<HttpStatus> createFishery() {
        buildingService.createFishery();
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<ProductionBuilding> postMethodName(@RequestParam String buildingType) {
        Class<? extends ProductionBuilding> buildingClass = (Class<? extends ProductionBuilding) Class.forName(buildingType);
        ProductionBuilding newBuilding = buildingService.createBuilding(buildingClass);
        return new ResponseEntity<>(newBuilding, HttpStatus.OK);
    }
    
    

}
