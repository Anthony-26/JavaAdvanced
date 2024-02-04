package com.example.citygame.model;

import java.util.Map;

import com.example.citygame.model.resources.Resource;

public abstract class Building {

    public static int idCounter = 0;
    private int id;
    private String name;
    private Map<Resource, Integer> constructionCost;

    protected Building(String name) {
        this.id = idCounter++;
        this.name = name;
    }

    public int getId(){
        return this.id;
    }

}