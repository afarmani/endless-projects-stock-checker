package com.endless.projects.stock.checker.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fasterxml.jackson.databind.ObjectMapper;

public class StockCheckerFunction implements RequestHandler {

    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Object handleRequest(Object input, Context context) {
        System.out.println("StockCheckerFunction");
        return null;
    }
}
