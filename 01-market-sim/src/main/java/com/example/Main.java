package com.example;

// import org.apache.logging.log4j.Logger;

// import org.apache.logging.log4j.LogManager;

import com.example.api.AlphaVantageClient;
import com.example.model.StockData;
import com.example.service.StockDataManager;
import com.example.util.FormatStock;

import java.util.Scanner;

public class Main {

    // private static final Logger logger =
    // LogManager.getLogger(Main.class.getName());

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StockDataManager manager = new StockDataManager();
        AlphaVantageClient client = new AlphaVantageClient();
        FormatStock fs = new FormatStock();

        while (true) {

            System.out.println("""

                    Menu :
                        0. Exit
                        1. Fetch a daily based stock data
                        2. Display the current stock list
                            """);
            String command = scanner.nextLine();

            if ("exit".equalsIgnoreCase(command) || "0".equalsIgnoreCase(command)) {
                System.out.println("Exiting program.");
                break;
            }

            switch (command) {
                case "1":
                    System.out.println("Enter stock ticker:");
                    String ticker = scanner.nextLine();
                    String s = client.getDailyStockInformation(ticker);
                    manager.addStockData(fs.FormatStockDaily(s));
                    System.out.println("Stock Data: " + s);
                    break;

                case "2":
                    System.out.println("Current list of stocks : " + manager.getRegisteredTickers());

                default:
                    System.out.println("Unknown command.");
                    break;
            }

        }

    }
}