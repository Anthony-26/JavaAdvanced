package com.example.model;

import java.math.BigDecimal;

public class StockData {

    private String stockTicker;
    private BigDecimal price;
    private BigDecimal changePercent;

    public StockData() {
    }

    public StockData(String stockTicker, BigDecimal price, BigDecimal changePercent) {
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

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getChangePercent() {
        return this.changePercent;
    }

    public void setChangePercent(BigDecimal changePercent) {
        this.changePercent = changePercent;
    }
    
}
