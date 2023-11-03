package com.gvlocke.weatherapp;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Locator {
    public Geolocation getLocation() {
        try {
            URL url = new URL("http://ip-api.com/json/?fields=status,message,countryCode,regionName,city,lat,lon,timezone");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responsecode = connection.getResponseCode();
            if (responsecode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                JSONObject jsonResponse = new JSONObject(response.toString());

                return new Geolocation(
                        jsonResponse.getString("status"),
                        jsonResponse.getString("countryCode"),
                        jsonResponse.getString("regionName"),
                        jsonResponse.getString("city"),
                        jsonResponse.getDouble("lat"),
                        jsonResponse.getDouble("lon"),
                        jsonResponse.getString("timezone")
                );
            }
            else {
                System.out.println("HTTP Request failed with response code: " + responsecode);
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}