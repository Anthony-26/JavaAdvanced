package com.example.citygame.model.resources;


public class Resource {

    private String name;
    private double quantity;
    private double productionRate;
    private double consumptionRate;

    public static final Resource FISH = new Resource("Fish");

    public Resource(String name) {
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

    public double getQuantity() {
        return this.quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getProductionRate() {
        return this.productionRate;
    }

    public void setProductionRate(double productionRate) {
        this.productionRate = productionRate;
    }

    public void increaseProductionRate(double rate) {
        this.productionRate += rate;
    }

    public void decreaseProductionRate(double rate) {
        this.productionRate -= rate;
    }

    public double getConsumptionRate() {
        return this.consumptionRate;
    }

    public void setConsumptionRate(double consumptionRate) {
        this.consumptionRate = consumptionRate;
    }

    public void increaseConsumptionRate(double rate) {
        this.consumptionRate += rate;
    }

    public void decreaseConsumptionRate(double rate) {
        this.consumptionRate -= rate;
    }

    public void addQuantity(double amount) {
        this.quantity += amount;
    }

    public void consumeQuantity(double amount) {
        this.quantity -= amount;
    }

}