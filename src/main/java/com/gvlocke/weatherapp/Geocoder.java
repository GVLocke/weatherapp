package com.gvlocke.weatherapp;

import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Geocoder {
    public static double @Nullable [] getLatLong(String placeName) {
        HttpClient client = HttpClients.createDefault();
        placeName = placeName.replace(' ', '+');
        String apiKey = null;
        try {
            File apiKeyFile = new File("apikey.txt");
            Scanner reader = new Scanner(apiKeyFile);
            apiKey = reader.nextLine();
        } catch (FileNotFoundException e) {
            System.out.println("Please create a file called apikey.txt with your Google API key.");
            e.printStackTrace();
        }
        String apiURL = "https://maps.googleapis.com/maps/api/geocode/json?address=" + placeName + "&key=" + apiKey;
        try {
            HttpGet request = new HttpGet(apiURL);
            CloseableHttpResponse response = (CloseableHttpResponse) client.execute(request);
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                String responseBody = EntityUtils.toString(entity);
                JSONObject jsonResponse = new JSONObject(responseBody);
                JSONArray results = jsonResponse.getJSONArray("results");

                if (!results.isEmpty()) {
                    JSONObject location = results.getJSONObject(0).getJSONObject("geometry").getJSONObject("location");
                    double latitude = location.getDouble("lat");
                    double longitude = location.getDouble("lng");
                    return new double[]{latitude, longitude};
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
