package com.example.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandler;
import java.net.http.HttpResponse.BodyHandlers;

import org.apache.logging.log4j.*;

import com.example.exceptions.RequestException;

public class AlphaVantageClient {

    private static final Logger logger = LogManager.getLogger(AlphaVantageClient.class.getName());

    String baseURI = "https://www.alphavantage.co/";
    String apiKey = System.getenv("AV_API_KEY");
    HttpClient client = HttpClient.newHttpClient();

    public String getSeries(String stockTicker, String type) {

        String timeSeries = "";
        String uri = "";

        if (type.equals("daily")) {
            uri = baseURI + String.format("query?function=TIME_SERIES_DAILY&outputsize=full&symbol=%s&apikey=%s",
                    stockTicker, apiKey);
        }

        if (type.equals("weekly")) {
            uri = baseURI + String.format("query?function=TIME_SERIES_WEEKLY&outputsize=full&symbol=%s&apikey=%s",
                    stockTicker, apiKey);
        }

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .build();

        try {
            timeSeries = client.sendAsync(request, BodyHandlers.ofString())

                    /* Verifying response status */
                    .thenApply(response -> {
                        if (response.statusCode() >= 200 && response.statusCode() < 300) {
                            return response.body();
                        } else {
                            throw new RequestException("HTTP Error", response.statusCode());
                        }
                    })

                    /* Verifying body content */
                    .thenApply(body -> {
                        if (!body.contains("Time Series (Daily)") && !body.contains("Weekly Time Series")) {
                            throw new RequestException(
                                    "Response does not contain stock information. \n\tReponse : " + body);
                        }
                        return body;
                    })

                    /* Handling Exceptions */
                    .exceptionally(e -> {
                        Throwable cause = e.getCause();
                        if (cause instanceof IOException) {
                            // logger.error("IOException: " + e.getMessage() + ". \n\tRequest : " + uri);
                        } else if (cause instanceof InterruptedException) {
                            // logger.error("InterruptedException: " + ". \n\tRequest : " + uri);
                            Thread.currentThread().interrupt();
                        } else {
                            // logger.error(e.getMessage() + ". \n\tRequest : " + uri);
                        }
                        return null;
                    })
                    .join();
        } catch (Exception e) {
            logger.error("Error caught during the try catch");
            System.err.println(e.getMessage());
        }
        return timeSeries.equals("") ? null : timeSeries;
    }

    public String getEMA(String ticker, String interval, int timePeriod) {
        /* Getting from the ticker the EMA */

        String uri = baseURI
                + String.format("query?function=EMA&symbol=%s&interval=%s&time_period=%d&series_type=close&apikey=%s",
                        ticker, interval, timePeriod, apiKey);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .build();

        String ts = client.sendAsync(request, BodyHandlers.ofString())
                .thenApply(response -> {
                    String body = response.body();
                    if (!body.contains("Technical Analysis: EMA"))
                        return null;
                    return body;
                })
                .join();

        return ts;
    }

}