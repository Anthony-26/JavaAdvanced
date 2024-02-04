package com.example.citygame.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.citygame.model.Building;
import com.example.citygame.model.productionbuildings.ProductionBuilding;
import com.example.citygame.service.BuildingService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




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
    
    @GetMapping("/get")
    public ResponseEntity<String> getMethodName(@RequestParam String buildingType) throws ReflectiveOperationException  {
        String fullyQualifiedName = "com.example.citygame.model.productionbuildings.";
        Class<? extends ProductionBuilding> buildingClass = (Class<? extends ProductionBuilding>) Class.forName(fullyQualifiedName + buildingType);
        List<ProductionBuilding> buildingList = buildingService.getAllBuildingWithType(buildingClass);
        return new ResponseEntity<>(String.valueOf(buildingList.get(0).getWorkforce()), HttpStatus.OK) ;
    }

    @GetMapping("/test")
    public ResponseEntity<HttpStatus> testFunction() {
        buildingService.testingMethod();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/void")
    public void voidEndpoint() {
        buildingService.voidEndpoint();
    }
    
    

}
