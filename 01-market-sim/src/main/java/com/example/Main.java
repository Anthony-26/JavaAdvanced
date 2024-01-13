package com.example;

import com.example.api.AlphaVantageClient;
import com.example.service.StockDataManager;
import com.example.util.FormatStock;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StockDataManager manager = new StockDataManager();
        AlphaVantageClient client = new AlphaVantageClient();
        FormatStock fs = new FormatStock();

        while (true) {

            System.out.println("""
                    \n-----------------------------------------------\n
                    Menu :
                        0. Exit
                        1. Adding a stock in the database
                        2. Display the current stock list
                        3. Get stock information

                    -----------------------------------------------

                    Select an action :""");

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
                    manager.addStockData(ticker.toUpperCase(), fs.FormatStockDaily(s));
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
                    if(ticker == null){
                        System.out.println("Ticker unknown.");
                        break;
                    }
                    if(manager.getRegisteredTickers().contains(ticker)){
                        System.out.println("\nData about " + ticker + " :");
                        System.out.println(manager.getStockDataMap().get(ticker));
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