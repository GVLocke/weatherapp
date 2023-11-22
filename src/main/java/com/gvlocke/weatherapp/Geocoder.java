package com.gvlocke.weatherapp;

import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;

public class Geocoder {

    protected final String API_KEY;
    public final String GEOCODING_API_URL = "https://maps.googleapis.com/maps/api/geocode/json";
    public Geocoder(String apiKey) {
        API_KEY = apiKey;
    }

    public Geolocation getGeolocation(String placeName) {
        HttpClient client = HttpClients.createDefault();
        placeName = placeName.replace(' ', '+');
        String apiURL = buildGeocodingURL(placeName);
        try {
            HttpGet request = new HttpGet(apiURL);
            CloseableHttpResponse response = (CloseableHttpResponse) client.execute(request);
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                String responseBody = EntityUtils.toString(entity);
                JSONObject jsonResponse = new JSONObject(responseBody);

                if ("OK".equals(jsonResponse.getString("status")) && jsonResponse.has("results")) {
                    JSONArray results = jsonResponse.getJSONArray("results");
                        if (!results.isEmpty()) {
                            JSONObject result = results.getJSONObject(0);
                            JSONObject location = result.getJSONObject("geometry").getJSONObject("location");
                            double latitude = location.getDouble("lat");
                            double longitude = location.getDouble("lng");
                            String countryName = "";
                            String stateName = "";
                            String cityName = "";

                            JSONArray addressComponents = result.getJSONArray("address_components");
                            for (int i = 0; i < addressComponents.length(); i++) {
                                JSONObject component = addressComponents.getJSONObject(i);
                                JSONArray types = component.getJSONArray("types");
                                if (types.toString().contains("country")) {
                                    countryName = component.getString("long_name");
                                } else if (types.toString().contains("administrative_area_level_1")) {
                                    stateName = component.getString("long_name");
                                } else if (types.toString().contains("locality")) {
                                    cityName = component.getString("long_name");
                                }
                            }
                            return new Geolocation(countryName, stateName, cityName, latitude,longitude);
                        } else {
                            System.out.println("No results found");
                        }
                } else {
                    System.out.println("Error in the geocoding response: " + jsonResponse.getString("status"));
                }
            } else {
                System.out.println("HTTP error");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String buildGeocodingURL(String placeName) {
        return String.format("%s?address=%s&key=%s", GEOCODING_API_URL, placeName, API_KEY);
    }
}
