package com.example.model;

import java.math.BigDecimal;

public class StockData {

    private BigDecimal price;
    private BigDecimal changePercent;

    public StockData() {
    }

    public StockData(BigDecimal price, BigDecimal changePercent) {
        this.price = price;
        this.changePercent = changePercent;
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

    @Override
    public String toString() {
        return "\t0. Price : " + this.getPrice()
                + "\n\t1. Change (in %) : " + this.getChangePercent() + "%";
    }

}
