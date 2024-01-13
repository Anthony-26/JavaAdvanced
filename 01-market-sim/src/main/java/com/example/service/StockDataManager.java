package com.example.service;

import java.util.HashSet;
import java.util.Set;

import com.example.model.StockData;

public class StockDataManager {
    
    private Set<StockData> stockDataList = new HashSet<StockData>();

    public StockDataManager() {
    }

    public StockDataManager(Set<StockData> stockDataList) {
        this.stockDataList = stockDataList;
    }

    public Set<StockData> getStockDataList() {
        return this.stockDataList;
    }

    public void setStockDataList(Set<StockData> stockDataList) {
        this.stockDataList = stockDataList;
    }

}
