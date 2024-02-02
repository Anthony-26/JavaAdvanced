package com.example.citygame.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.citygame.service.BuildingService;

import lombok.RequiredArgsConstructor;

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
    

}
