package com.example.citygame.model;

public abstract class Building {
    
    private static int idCounter = 0;
    private int id;
    private String name;

    Building(String name){
        this.id = idCounter++;
        this.name = name;
    }

}
