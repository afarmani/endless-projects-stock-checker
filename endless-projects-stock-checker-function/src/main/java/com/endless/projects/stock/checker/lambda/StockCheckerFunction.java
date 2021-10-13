package com.endless.projects.stock.checker.lambda;

import com.amazonaws.services.lambda.runtime.Context;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

public class StockCheckerFunction extends BaseFunction {

    private static final String URL_TO_CHECK = "https://www.bestbuy.ca/ecomm-api/availability/products?accept=application%2Fvnd.bestbuy.simpleproduct.v1%2Bjson&accept-language=en-CA&locations=910%7C544%7C795%7C916%7C954%7C207%7C926%7C622%7C932%7C57%7C200%7C202%7C938%7C233%7C927%7C617%7C990%7C930%7C237%7C203%7C62%7C956%7C977%7C931%7C245%7C615%7C965%7C937%7C943%7C985%7C949%7C942%7C631&postalCode=L6R1Z8&skus=15463567%7C15166285%7C15078017%7C15530046%7C15463568%7C15530045%7C14969729%7C15318940%7C14954116%7C15229237%7C10416248%7C15309513%7C15084753%7C15546964%7C15147122%7C15309514%7C15373182%7C15524485%7C15493494%7C14954117%7C15317226%7C15547752%7C15201199%7C15201201";

    @Override
    public String process(Map<String, String> event, Context context) {
        InputStream response = null;
        try {
            URLConnection urlConnection = new URL(URL_TO_CHECK).openConnection();
            urlConnection.setRequestProperty("user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/94.0.4606.71 Safari/537.36");
            response = urlConnection.getInputStream();
            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }
}
