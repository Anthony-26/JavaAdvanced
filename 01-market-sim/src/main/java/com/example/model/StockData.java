package com.example.model;

public class StockData {

    private String stockTicker;
    private int price;
    private int changePercent;

    public StockData() {
    }

    public StockData(String stockTicker, int price, int changePercent) {
        this.stockTicker = stockTicker;
        this.price = price;
        this.changePercent = changePercent;
    }

    public String getStockTicker() {
        return this.stockTicker;
    }

    public void setStockTicker(String stockTicker) {
        this.stockTicker = stockTicker;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getChangePercent() {
        return this.changePercent;
    }

    public void setChangePercent(int changePercent) {
        this.changePercent = changePercent;
    }

}
