package com.latest.news.service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NewsService {

    private static final String API_KEY = "0ca85727c01e434f9d8cbb88e336254d"; // Replace with your API key
    private static final String API_URL = "https://newsapi.org/v2/everything";

    public String getTopNews() {
        StringBuilder response = new StringBuilder();
        try {
            String urlString = API_URL + "?q=apple&from=2025-01-30&to=2025-01-30&sortBy=popularity&apiKey=" + API_KEY;
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // Success
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
            } else {
                System.out.println("GET request failed with response code: " + responseCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response.toString();
    }

    public JsonArray parseNewsData(String jsonData) {
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(jsonData, JsonObject.class);
        return jsonObject.getAsJsonArray("articles"); // Extract the "articles" array
    }
}