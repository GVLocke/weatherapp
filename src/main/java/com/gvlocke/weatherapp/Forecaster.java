package com.gvlocke.weatherapp;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;

public class Forecaster {
    public Weather getWeather() {
        // create a client object to send HTTP requests
        HttpClient httpClient = HttpClients.createDefault();

        // get the geolocation of the user by making a request to ip-api.com
        Geolocation geolocation = new Locator().getLocation();

        // print the geolocation to the console
        System.out.println(geolocation);

        // create a string containing the URL of the API endpoint including the geolocation data
        String apiURL = "https://api.open-meteo.com/v1/forecast?latitude=" + geolocation.getLat() + "&longitude=" + geolocation.getLon() + "&current=temperature_2m,precipitation,rain,showers,snowfall,windspeed_10m,winddirection_10m&hourly=temperature_2m,precipitation_probability,precipitation,rain,showers,snowfall,snow_depth,windspeed_10m,winddirection_10m&temperature_unit=fahrenheit&windspeed_unit=mph&precipitation_unit=inch&timezone=auto";
        try {
            HttpGet request = new HttpGet(apiURL);

            CloseableHttpResponse response = (CloseableHttpResponse) httpClient.execute(request);
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                String responseBody = EntityUtils.toString(entity);
                JSONObject jsonResponse = new JSONObject(responseBody);

                JSONObject hourlyData = jsonResponse.getJSONObject("hourly");
                List<String> timeList = jsonArrayToList(hourlyData.getJSONArray("time"));
                List<Double> temperature_2mList = jsonArrayToList(hourlyData.getJSONArray("temperature_2m"));
                List<Double> precipitation_probabilityList = jsonArrayToList(hourlyData.getJSONArray("precipitation_probability"));
                List<Double> precipitationList = jsonArrayToList(hourlyData.getJSONArray("precipitation"));
                List<Double> rainList = jsonArrayToList(hourlyData.getJSONArray("rain"));
                List<Double> showersList = jsonArrayToList(hourlyData.getJSONArray("showers"));
                List<Double> snowfallList = jsonArrayToList(hourlyData.getJSONArray("snowfall"));
                List<Double> snow_depthList = jsonArrayToList(hourlyData.getJSONArray("snow_depth"));
                List<Double> windspeed_10mList = jsonArrayToList(hourlyData.getJSONArray("windspeed_10m"));
                List<Integer> winddirection_10mList = jsonArrayToList(hourlyData.getJSONArray("winddirection_10m"));

                return new Weather(
                        jsonResponse.getDouble("latitude"),
                        jsonResponse.getDouble("longitude"),
                        jsonResponse.getDouble("generationtime_ms"),
                        jsonResponse.getInt("utc_offset_seconds"),
                        jsonResponse.getString("timezone"),
                        jsonResponse.getString("timezone_abbreviation"),
                        jsonResponse.getDouble("elevation"),
                        new CurrentUnits(
                                jsonResponse.getJSONObject("current_units").getString("time"),
                                jsonResponse.getJSONObject("current_units").getString("interval"),
                                jsonResponse.getJSONObject("current_units").getString("temperature_2m"),
                                jsonResponse.getJSONObject("current_units").getString("precipitation"),
                                jsonResponse.getJSONObject("current_units").getString("rain"),
                                jsonResponse.getJSONObject("current_units").getString("showers"),
                                jsonResponse.getJSONObject("current_units").getString("snowfall"),
                                jsonResponse.getJSONObject("current_units").getString("windspeed_10m"),
                                jsonResponse.getJSONObject("current_units").getString("winddirection_10m")
                        ),
                        new Current(
                                jsonResponse.getJSONObject("current").getString("time"),
                                jsonResponse.getJSONObject("current").getInt("interval"),
                                jsonResponse.getJSONObject("current").getDouble("temperature_2m"),
                                jsonResponse.getJSONObject("current").getDouble("precipitation"),
                                jsonResponse.getJSONObject("current").getDouble("rain"),
                                jsonResponse.getJSONObject("current").getDouble("showers"),
                                jsonResponse.getJSONObject("current").getDouble("snowfall"),
                                jsonResponse.getJSONObject("current").getDouble("windspeed_10m"),
                                jsonResponse.getJSONObject("current").getDouble("winddirection_10m")
                        ),
                        new HourlyUnits(
                                jsonResponse.getJSONObject("hourly_units").getString("time"),
                                jsonResponse.getJSONObject("hourly_units").getString("temperature_2m"),
                                jsonResponse.getJSONObject("hourly_units").getString("precipitation_probability"),
                                jsonResponse.getJSONObject("hourly_units").getString("precipitation"),
                                jsonResponse.getJSONObject("hourly_units").getString("rain"),
                                jsonResponse.getJSONObject("hourly_units").getString("showers"),
                                jsonResponse.getJSONObject("hourly_units").getString("snowfall"),
                                jsonResponse.getJSONObject("hourly_units").getString("snow_depth"),
                                jsonResponse.getJSONObject("hourly_units").getString("windspeed_10m"),
                                jsonResponse.getJSONObject("hourly_units").getString("winddirection_10m")
                        ),
                        new Hourly(
                                timeList,
                                temperature_2mList,
                                precipitation_probabilityList,
                                precipitationList,
                                rainList,
                                showersList,
                                snowfallList,
                                snow_depthList,
                                windspeed_10mList,
                                winddirection_10mList
                        ));
            }
            else {
                System.out.println("HTTP Request failed with response code: " + response.getStatusLine().getStatusCode());
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private <T> List<T> jsonArrayToList(JSONArray jsonArray) {
        List<T> list = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            list.add((T) jsonArray.get(i));
        }
        return list;
    }
}