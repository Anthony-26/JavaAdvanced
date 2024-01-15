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
                },
                "2024-01-10": {
                    "1. open": "160.2800",
                    "2. high": "161.3400",
                    "3. low": "159.7400",
                    "4. close": "161.2300",
                    "5. volume": "2967852"
                },
                "2024-01-09": {
                    "1. open": "160.0000",
                    "2. high": "160.4837",
                    "3. low": "159.5100",
                    "4. close": "160.0800",
                    "5. volume": "2617186"
                },
                "2024-01-08": {
                    "1. open": "158.6900",
                    "2. high": "161.2160",
                    "3. low": "157.8850",
                    "4. close": "161.1400",
                    "5. volume": "3321698"
                },
                "2024-01-05": {
                    "1. open": "159.9100",
                    "2. high": "160.5500",
                    "3. low": "158.6700",
                    "4. close": "159.1600",
                    "5. volume": "3698961"
                },
                "2024-01-04": {
                    "1. open": "160.2200",
                    "2. high": "161.8100",
                    "3. low": "160.1700",
                    "4. close": "160.8600",
                    "5. volume": "3212004"
                },
                "2024-01-03": {
                    "1. open": "161.0000",
                    "2. high": "161.7300",
                    "3. low": "160.0800",
                    "4. close": "160.1000",
                    "5. volume": "4086065"
                },
                "2024-01-02": {
                    "1. open": "162.8300",
                    "2. high": "163.2900",
                    "3. low": "160.4600",
                    "4. close": "161.5000",
                    "5. volume": "3825044"
                },
                "2023-12-29": {
                    "1. open": "163.7500",
                    "2. high": "164.1800",
                    "3. low": "162.8300",
                    "4. close": "163.5500",
                    "5. volume": "2526169"
                },
                "2023-12-28": {
                    "1. open": "163.9600",
                    "2. high": "163.9600",
                    "3. low": "163.4000",
                    "4. close": "163.7500",
                    "5. volume": "2071313"
                },
                "2023-12-27": {
                    "1. open": "163.1400",
                    "2. high": "163.6400",
                    "3. low": "162.6800",
                    "4. close": "163.4600",
                    "5. volume": "3006612"
                },
                "2023-12-26": {
                    "1. open": "162.2300",
                    "2. high": "163.3100",
                    "3. low": "162.0500",
                    "4. close": "163.2100",
                    "5. volume": "1772443"
                },
                "2023-12-22": {
                    "1. open": "161.1000",
                    "2. high": "162.4100",
                    "3. low": "161.0000",
                    "4. close": "162.1400",
                    "5. volume": "2442715"
                },
                "2023-12-21": {
                    "1. open": "160.5900",
                    "2. high": "161.0800",
                    "3. low": "159.5300",
                    "4. close": "160.7800",
                    "5. volume": "2982924"
                },
                "2023-12-20": {
                    "1. open": "161.2900",
                    "2. high": "161.8000",
                    "3. low": "160.0100",
                    "4. close": "160.0500",
                    "5. volume": "4865797"
                },
                "2023-12-19": {
                    "1. open": "161.8000",
                    "2. high": "162.2800",
                    "3. low": "161.3200",
                    "4. close": "161.5600",
                    "5. volume": "3717429"
                },
                "2023-12-18": {
                    "1. open": "162.2300",
                    "2. high": "163.3300",
                    "3. low": "161.5766",
                    "4. close": "162.7400",
                    "5. volume": "3677533"
                },
                "2023-12-15": {
                    "1. open": "162.3000",
                    "2. high": "164.0900",
                    "3. low": "162.0400",
                    "4. close": "162.2300",
                    "5. volume": "11016108"
                },
                "2023-12-14": {
                    "1. open": "162.9300",
                    "2. high": "163.4990",
                    "3. low": "160.1490",
                    "4. close": "162.9100",
                    "5. volume": "6129804"
                },
                "2023-12-13": {
                    "1. open": "164.3700",
                    "2. high": "164.9653",
                    "3. low": "162.7350",
                    "4. close": "163.6200",
                    "5. volume": "4989141"
                },
                "2023-12-12": {
                    "1. open": "163.2700",
                    "2. high": "166.3400",
                    "3. low": "162.9200",
                    "4. close": "164.7100",
                    "5. volume": "5292290"
                },
                "2023-12-11": {
                    "1. open": "162.6800",
                    "2. high": "163.6500",
                    "3. low": "161.9500",
                    "4. close": "163.5100",
                    "5. volume": "6077207"
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