package com.example.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.example.model.StockData;

public class StockDataManager {

    private Set<StockData> stockDataList = new HashSet<StockData>();

    public StockDataManager() {
    }

    public StockDataManager(Set<StockData> stockDataList) {
        this.stockDataList = stockDataList;
    }

    public Set<String> getRegisteredTickers() {
        Set<String> stockTickers = new HashSet<>();
        for(StockData sd : stockDataList){
            stockTickers.add(sd.getStockTicker());
        }
        return stockTickers;
    }

    public void setStockDataList(Set<StockData> stockDataList) {
        this.stockDataList = stockDataList;
    }

    public void addStockData(StockData stockData) {
        if (stockData != null) {
            stockDataList.add(stockData);
        }
    }
}
