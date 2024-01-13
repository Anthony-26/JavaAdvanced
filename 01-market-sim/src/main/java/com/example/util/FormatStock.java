package com.example.util;

import java.math.BigDecimal;

import com.example.model.StockData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FormatStock {

    public FormatStock() {
    }

    public StockData FormatStockDaily(String stockData) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(stockData);
            JsonNode globalQuote = rootNode.get("Global Quote");

            StockData sd = new StockData(
                    globalQuote.get("01. symbol").asText(),
                    new BigDecimal(globalQuote.get("05. price").asText()),
                    new BigDecimal(globalQuote.get("10. change percent").asText().replace("%", "")));

            return sd;
        } catch (JsonProcessingException e) {

        }

        return null;

    }

}
