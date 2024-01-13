package com.example;

// import org.apache.logging.log4j.Logger;
// import org.apache.logging.log4j.LogManager;

import com.example.api.AlphaVantageClient;


public class Main {

    // private static final Logger logger = LogManager.getLogger(Main.class.getName());
    public static void main(String[] args) {
        
        AlphaVantageClient client = new AlphaVantageClient();
        client.sendRequest();

    }
}