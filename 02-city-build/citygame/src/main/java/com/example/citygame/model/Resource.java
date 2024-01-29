package com.example.citygame.model;

public abstract class Resource {

    private String name;
    private int quantity;
    private int productionRate;
    private int consumptionRate;

    Resource(String name) {
        this.name = name;
        this.quantity = 0;
        this.productionRate = 0;
        this.consumptionRate = 0;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getProductionRate() {
        return this.productionRate;
    }

    public void setProductionRate(int productionRate) {
        this.productionRate = productionRate;
    }

    public void increaseProductionRate(int rate){
        this.productionRate += rate;
    }

    public int getConsumptionRate() {
        return this.consumptionRate;
    }

    public void setConsumptionRate(int consumptionRate) {
        this.consumptionRate = consumptionRate;
    }

    public void addQuantity(int amount) {
        this.quantity += amount;
    }

    public void consumeQuantity(int amount) {
        this.quantity -= amount;
    }

}
