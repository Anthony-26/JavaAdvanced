package com.example.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;

import org.apache.logging.log4j.*;

import com.example.exceptions.RequestException;

public class AlphaVantageClient {

    public String json_datafi = """
        {
            "Meta Data": {
                "1. Information": "Daily Prices (open, high, low, close) and Volumes",
                "2. Symbol": "IBM",
                "3. Last Refreshed": "2024-01-12",
                "4. Output Size": "Full size",
                "5. Time Zone": "US/Eastern"
            },
            "Time Series (Daily)": {
                "2024-01-12": {
                    "1. open": "162.9700",
                    "2. high": "165.9800",
                    "3. low": "162.3550",
                    "4. close": "165.8000",
                    "5. volume": "4958261"
                },
                "2024-01-11": {
                    "1. open": "161.0200",
                    "2. high": "162.2300",
                    "3. low": "160.2900",
                    "4. close": "162.1600",
                    "5. volume": "3778395"
                }
            }
        }""";

    private String apiKey = System.getenv("AV_API_KEY");
    // private String apiKey = null;

    private static final Logger logger = LogManager.getLogger(AlphaVantageClient.class.getName());

    HttpClient client = HttpClient.newHttpClient();

    public String getDailyStockInformation(String stockTicker) {

        return json_datafi;

        /* Uncomment for real data */

        // String dailyStockInformation = "";

        // String uri =
        // String.format("https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=%s&apikey=%s",
        // stockTicker, apiKey);

        // HttpRequest request = HttpRequest.newBuilder()
        // .uri(URI.create(uri))
        // .build();

        // try {
        // dailyStockInformation = client.sendAsync(request, BodyHandlers.ofString())

        // /* Verifying response status */
        // .thenApply(response -> {
        // if (response.statusCode() >= 200 && response.statusCode() < 300) {
        // return response.body();
        // } else {
        // throw new RequestException("HTTP Error", response.statusCode());
        // }
        // })

        // /* Verifying body content */
        // .thenApply(body -> {
        // if (!body.contains("01. symbol")) {
        // throw new RequestException(
        // "Response does not contain stock information. \n\tReponse : " + body);
        // }
        // return body;
        // })

        // /* Handling Exceptions */
        // .exceptionally(e -> {
        // Throwable cause = e.getCause();
        // if (cause instanceof IOException) {
        // // logger.error("IOException: " + e.getMessage() + ". \n\tRequest : " + uri);
        // } else if (cause instanceof InterruptedException) {
        // // logger.error("InterruptedException: " + ". \n\tRequest : " + uri);
        // Thread.currentThread().interrupt();
        // } else {
        // // logger.error(e.getMessage() + ". \n\tRequest : " + uri);
        // }
        // return null;
        // })
        // .join();
        // } catch (Exception e) {
        // logger.error("Error caught during the try catch");
        // System.err.println(e.getMessage());
        // }
        // return dailyStockInformation;
    }

    public String getDailyData(String stockTicker) {

        return json_datafi;
    }
}