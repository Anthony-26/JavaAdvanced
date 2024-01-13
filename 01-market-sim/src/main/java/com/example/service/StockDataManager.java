package com.example.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.model.StockData;

public class StockDataManager {

    private Map<String, StockData> stockDataMap = new HashMap<>();

    public StockDataManager() {
    }

    public List<String> getRegisteredTickers() {
        List<String> stockTickers = new ArrayList<>();
        for (String ticker : stockDataMap.keySet()) {
            stockTickers.add(ticker);
        }
        return stockTickers;
    }

    public Map<String, StockData> getStockDataMap() {
        return this.stockDataMap;
    }

    public void setStockDataMap(Map<String, StockData> stockDataMap) {
        this.stockDataMap = stockDataMap;
    }

    public void addStockData(String ticker, StockData stockData) {
        if (stockData != null && ticker != null) {
            stockDataMap.put(ticker, stockData);
        }
    }
}
