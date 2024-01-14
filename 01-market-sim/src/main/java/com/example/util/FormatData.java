package com.example.util;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.model.DailySerie;
import com.example.model.StockData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FormatData {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static StockData FormatDataDaily(String stockData) {
        try {
            JsonNode rootNode = objectMapper.readTree(stockData);
            JsonNode globalQuote = rootNode.get("Global Quote");

            StockData sd = new StockData(
                    new BigDecimal(globalQuote.get("05. price").asText()),
                    new BigDecimal(globalQuote.get("10. change percent").asText().replace("%", "")));

            return sd;
        } catch (JsonProcessingException e) {

        }
        return null;
    }

    public static Map<LocalDate, DailySerie> getFormattedDailySeries(String data) {
        try {
            Map<LocalDate, DailySerie> dailySeries = new HashMap<>();
            JsonNode jsonData = objectMapper.readTree(data);
            JsonNode timeSerieDaily = jsonData.get("Time Series (Daily)");

            List<String> ls = new ArrayList<>();
            List<DailySerie> ds = new ArrayList<>();
            timeSerieDaily.fields().forEachRemaining(e -> {
                JsonNode td = e.getValue();
                ls.add(e.getKey());
                ds.add(new DailySerie(
                    new BigDecimal(td.get("1. open").asText()),
                    new BigDecimal(td.get("1. open").asText()),
                    new BigDecimal(td.get("1. open").asText()),
                    new BigDecimal(td.get("1. open").asText()),
                    (td.get("5. volume").asInt())
                ));
            });
            System.out.println(ls.get(0));


        } catch (JsonProcessingException e) {

        }
        return null;
    }
}
