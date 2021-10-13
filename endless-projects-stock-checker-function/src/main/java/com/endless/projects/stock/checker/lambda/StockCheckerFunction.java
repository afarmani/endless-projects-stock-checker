package com.endless.projects.stock.checker.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class StockCheckerFunction implements RequestHandler {

    private static final String URL_TO_CHECK = "https://www.bestbuy.ca/en-ca/category/graphics-cards/20397";

    ObjectMapper objectMapper = new ObjectMapper();
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public Object handleRequest(Object input, Context context) {
        LambdaLogger logger = context.getLogger();
        logger.log("CONTEXT: " + gson.toJson(context));

        InputStream response = null;
        try {
            URLConnection urlConnection = new URL(URL_TO_CHECK).openConnection();
            response = urlConnection.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("StockCheckerFunction");
        return null;
    }
}
