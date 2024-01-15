package com.example.util;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.TreeMap;

import com.example.model.PricesTimeSerie;
import com.example.model.StockData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FormatData {

    private static ObjectMapper objectMapper = new ObjectMapper();
    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

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

    public static TreeMap<LocalDate, PricesTimeSerie> getFormattedTimeSeries(String data) {
        try {
            TreeMap<LocalDate, PricesTimeSerie> dailySeries = new TreeMap<>();

            JsonNode jsonData = objectMapper.readTree(data);
            JsonNode timeSerieDaily = jsonData.get("Time Series (Daily)");

            timeSerieDaily.fields().forEachRemaining(timeSerie -> {
                JsonNode values = timeSerie.getValue();
                String date = timeSerie.getKey();

                dailySeries.put(
                        LocalDate.parse(date, dateTimeFormatter),
                        new PricesTimeSerie(
                                new BigDecimal(values.get("1. open").asText()),
                                new BigDecimal(values.get("1. open").asText()),
                                new BigDecimal(values.get("1. open").asText()),
                                new BigDecimal(values.get("1. open").asText()),
                                (values.get("5. volume").asInt())));
            });

            return dailySeries;

        } catch (JsonProcessingException e) {

        }
        return null;
    }
}
