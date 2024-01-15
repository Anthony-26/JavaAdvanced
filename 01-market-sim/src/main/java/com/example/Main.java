package com.example;

import com.example.api.AlphaVantageClient;
import com.example.model.PricesTimeSerie;
import com.example.service.StockDataManager;
import com.example.util.FormatData;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StockDataManager manager = new StockDataManager();
        AlphaVantageClient client = new AlphaVantageClient();

        while (true) {

            System.out.println("""

                    -----------------------------------------------

                    Menu :
                        0. Exit
                        1. Adding a stock to the database
                        2. Display the current stock list
                        3. Get stock information
                        4. Analyze on a specific stock

                    -----------------------------------------------
                    """);

            System.out.print("Select an action : ");
            String command = scanner.nextLine();

            if ("exit".equalsIgnoreCase(command) || "0".equalsIgnoreCase(command)) {
                System.out.println("Exiting program.");
                break;
            }

            switch (command) {
                case "1":
                    System.out.println("\nEnter stock ticker:");
                    String ticker = scanner.nextLine();
                    String s = ticker == null ? null : client.getDailyStockInformation(ticker);
                    if (s == null) {
                        System.out.println("\nError, " + ticker + " may not be an existig value and cannot be null.");
                        break;
                    }
                    manager.addStockData(ticker.toUpperCase(), FormatData.FormatDataDaily(s));
                    System.out.println("Stock Data: " + s);
                    break;

                case "2":
                    System.out
                            .println("\nThe current list contains " + manager.getStockDataMap().size() + " stock(s).");
                    System.out.println(manager.getRegisteredTickers());
                    break;

                case "3":
                    System.out.println("\nEnter a known ticker : ");
                    ticker = scanner.nextLine().toUpperCase();
                    if (ticker == null) {
                        System.out.println("Ticker unknown.");
                        break;
                    }
                    if (manager.getRegisteredTickers().contains(ticker)) {
                        System.out.println("\nData about " + ticker + " :");
                        System.out.println(manager.getStockDataMap().get(ticker));
                    }
                    break;

                case "4":
                    while (true) {
                        System.out.println("\nSelect a stock to analyze :");
                        ticker = scanner.nextLine().toUpperCase();

                        if (ticker == null || ticker.isEmpty()) {
                            System.out.println("\nPlease enter a valid ticker.");
                        } else {
                            if (ticker.equals("0")) {
                                break;
                            }
                            ticker = ticker.toUpperCase();
                            String dailyData = client.getDailyData(ticker);
                            if (dailyData == null) {
                                System.out.println(
                                        "\nError, this ticker apparently does not exist. Please try again.");
                            } else {
                                TreeMap<LocalDate, PricesTimeSerie> dailySeries =  FormatData
                                        .getFormattedTimeSeries(dailyData);
                                ;
                                /* Load weekly & monthly series */
                                if (dailySeries == null) {
                                    System.out.println("\nCannot load the data of " + ticker + ". Please try again.");
                                } else {
                                    System.out.println("\nData of " + ticker + " successfully loaded.");
                                    System.out.println("""


                                            -----------------------------------------------

                                            Option for %s  :

                                                1. Display price (20 last days).
                                                2. Display data

                                            -----------------------------------------------
                                            """.formatted(ticker));

                                    System.out.print("Select an action : ");
                                    command = scanner.nextLine();

                                    switch (command) {

                                        case "1":
                                            System.out.println();
                                            for (LocalDate ld : dailySeries.keySet()) {
                                                System.out
                                                        .println(ld.toString() + " " + dailySeries.get(ld).getClose());
                                            }
                                            break;

                                        case "2":

                                            LocalDate mostRecentDate = dailySeries.lastKey();
                                            LocalDate dateOneMonthBefore = mostRecentDate.minusMonths(1);
                                            BigDecimal highest30dPrice = dailySeries.get(mostRecentDate).getHigh();
                                            BigDecimal lowest30dPrice = dailySeries.get(mostRecentDate).getLow();

                                            for (Map.Entry<LocalDate, PricesTimeSerie> entry : dailySeries
                                                    .subMap(dateOneMonthBefore, true, mostRecentDate, true)
                                                    .entrySet()) {
                                                BigDecimal highPrice = entry.getValue().getHigh();
                                                BigDecimal lowPrice = entry.getValue().getLow();

                                                /* Debugging output */
                                                // System.out.println("Date : " + entry.getKey() + " currentHigh : " + highest30dPrice + " compared to newHigh : " + highPrice);
                                                // System.out.println("Date : " + entry.getKey() + " currentLow : " + lowest30dPrice + " compared to newLow : " + lowPrice);

                                                if (highPrice.compareTo(highest30dPrice) > 0) {
                                                    highest30dPrice = highPrice;
                                                } if (lowest30dPrice.compareTo(lowPrice) > 0) {
                                                    lowest30dPrice = lowPrice;
                                                }
                                            }

                                            System.out.println("""

                                                    30 Days High/Low :                  
                                                        $%,.2f | $%,.2f             
                                                    """.formatted(highest30dPrice.doubleValue(),
                                                    lowest30dPrice.doubleValue()));
                                            break;

                                        default:
                                            break;
                                    }
                                }
                            }
                        }
                    }
                    break;

                default:
                    System.out.println("test");
                    break;
            }

        }
        scanner.close();

    }
}