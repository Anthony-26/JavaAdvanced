package com.example;

import com.example.api.AlphaVantageClient;
import com.example.model.PricesTimeSerie;
import com.example.service.StockDataManager;
import com.example.util.Actions;
import com.example.util.FormatData;

import java.time.LocalDate;
import java.util.Scanner;
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

                            /* WORKING WITH FAKE DATA */
                            // String dailyData = client.getDailyData(ticker);

                            /* WORKING WITH REAL DATA */
                            String dailyData = client.getDailyStockInformation(ticker);

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

                                            System.out.println(
                                                    Actions.getDataFromTreeMap(dailySeries));

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
                    System.out.println("  Please select a valid action or type \"exit\".");
                    break;
            }
        }
        scanner.close();
    }
}