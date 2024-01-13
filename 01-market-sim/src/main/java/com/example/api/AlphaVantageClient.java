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
            "Global Quote": {
                "01. symbol": "IBM",
                "02. open": "162.9700",
                "03. high": "165.9800",
                "04. low": "162.3550",
                "05. price": "165.8000",
                "06. volume": "4958261",
                "07. latest trading day": "2024-01-12",
                "08. previous close": "162.1600",
                "09. change": "3.6400",
                "10. change percent": "2.2447%"
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

        // String uri = String.format("https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=%s&apikey=%s",
        //         stockTicker, apiKey);

        // HttpRequest request = HttpRequest.newBuilder()
        //         .uri(URI.create(uri))
        //         .build();

        // try {
        //     dailyStockInformation = client.sendAsync(request, BodyHandlers.ofString())

        //             /* Verifying response status */
        //             .thenApply(response -> {
        //                 if (response.statusCode() >= 200 && response.statusCode() < 300) {
        //                     return response.body();
        //                 } else {
        //                     throw new RequestException("HTTP Error", response.statusCode());
        //                 }
        //             })

        //             /* Verifying body content */
        //             .thenApply(body -> {
        //                 if (!body.contains("01. symbol")) {
        //                     throw new RequestException(
        //                             "Response does not contain stock information. \n\tReponse : " + body);
        //                 }
        //                 return body;
        //             })

        //             /* Handling Exceptions */
        //             .exceptionally(e -> {
        //                 Throwable cause = e.getCause();
        //                 if (cause instanceof IOException) {
        //                     // logger.error("IOException: " + e.getMessage() + ". \n\tRequest : " + uri);
        //                 } else if (cause instanceof InterruptedException) {
        //                     // logger.error("InterruptedException: " + ". \n\tRequest : " + uri);
        //                     Thread.currentThread().interrupt();
        //                 } else {
        //                     // logger.error(e.getMessage() + ". \n\tRequest : " + uri);
        //                 }
        //                 return null;
        //             })
        //             .join();
        // } catch (Exception e) {
        //     logger.error("Error caught during the try catch");
        //     System.err.println(e.getMessage());
        // }
        // return dailyStockInformation;
    }
}