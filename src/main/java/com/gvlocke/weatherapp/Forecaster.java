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
import java.util.ArrayList;
import java.util.List;

public class Forecaster {
    public Weather getWeather(Geolocation geolocation) {
        // create a client object to send HTTP requests
        HttpClient httpClient = HttpClients.createDefault();

        // print the geolocation to the console
        System.out.println(geolocation);

        // create a string containing the URL of the API endpoint including the geolocation data
        String apiURL = "https://api.open-meteo.com/v1/forecast?latitude=" + geolocation.lat() + "&longitude=" + geolocation.lon() + "&current=temperature_2m,is_day,precipitation,rain,showers,snowfall,weather_code,windspeed_10m,winddirection_10m,wind_gusts_10m&hourly=temperature_2m,precipitation_probability,precipitation,rain,showers,snowfall,snow_depth,windspeed_10m,winddirection_10m&daily=temperature_2m_max,temperature_2m_min,sunrise,sunset,precipitation_sum,rain_sum,showers_sum,snowfall_sum,precipitation_hours&temperature_unit=fahrenheit&windspeed_unit=mph&precipitation_unit=inch&timezone=auto";
        try {
            HttpGet request = new HttpGet(apiURL);

            CloseableHttpResponse response = (CloseableHttpResponse) httpClient.execute(request);
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                String responseBody = EntityUtils.toString(entity);
                JSONObject jsonResponse = new JSONObject(responseBody);

                JSONObject hourlyData = jsonResponse.getJSONObject("hourly");
                List<String> hourlyTimeList = jsonArrayToList(hourlyData.getJSONArray("time"));
                List<Double> temperature_2mList = jsonArrayToList(hourlyData.getJSONArray("temperature_2m"));
                List<Double> precipitation_probabilityList = jsonArrayToList(hourlyData.getJSONArray("precipitation_probability"));
                List<Double> precipitationList = jsonArrayToList(hourlyData.getJSONArray("precipitation"));
                List<Double> rainList = jsonArrayToList(hourlyData.getJSONArray("rain"));
                List<Double> showersList = jsonArrayToList(hourlyData.getJSONArray("showers"));
                List<Double> snowfallList = jsonArrayToList(hourlyData.getJSONArray("snowfall"));
                List<Double> snow_depthList = jsonArrayToList(hourlyData.getJSONArray("snow_depth"));
                List<Double> windspeed_10mList = jsonArrayToList(hourlyData.getJSONArray("windspeed_10m"));
                List<Integer> winddirection_10mList = jsonArrayToList(hourlyData.getJSONArray("winddirection_10m"));

                JSONObject dailyData = jsonResponse.getJSONObject("daily");
                List<String> dailyTimeList = jsonArrayToList(dailyData.getJSONArray("time"));
                List<Double> temperature_2m_maxList = jsonArrayToList(dailyData.getJSONArray("temperature_2m_max"));
                List<Double> temperature_2m_minList = jsonArrayToList(dailyData.getJSONArray("temperature_2m_min"));
                List<String> sunriseList = jsonArrayToList(dailyData.getJSONArray("sunrise"));
                List<String> sunsetList = jsonArrayToList(dailyData.getJSONArray("sunset"));
                List<Double> precipitation_sumList = jsonArrayToList(dailyData.getJSONArray("precipitation_sum"));
                List<Double> rain_sumList = jsonArrayToList(dailyData.getJSONArray("rain_sum"));
                List<Double> showers_sumList = jsonArrayToList(dailyData.getJSONArray("showers_sum"));
                List<Double> snowfall_sumList = jsonArrayToList(dailyData.getJSONArray("snowfall_sum"));
                List<Double> precipitation_hoursList = jsonArrayToList(dailyData.getJSONArray("precipitation_hours"));

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
                                jsonResponse.getJSONObject("current_units").getString("weather_code"),
                                jsonResponse.getJSONObject("current_units").getString("windspeed_10m"),
                                jsonResponse.getJSONObject("current_units").getString("winddirection_10m"),
                                jsonResponse.getJSONObject("current_units").getString("wind_gusts_10m")
                        ),
                        new Current(
                                jsonResponse.getJSONObject("current").getString("time"),
                                jsonResponse.getJSONObject("current").getInt("interval"),
                                jsonResponse.getJSONObject("current").getDouble("temperature_2m"),
                                jsonResponse.getJSONObject("current").getInt("is_day"),
                                jsonResponse.getJSONObject("current").getDouble("precipitation"),
                                jsonResponse.getJSONObject("current").getDouble("rain"),
                                jsonResponse.getJSONObject("current").getDouble("showers"),
                                jsonResponse.getJSONObject("current").getDouble("snowfall"),
                                jsonResponse.getJSONObject("current").getInt("weather_code"),
                                jsonResponse.getJSONObject("current").getDouble("windspeed_10m"),
                                jsonResponse.getJSONObject("current").getDouble("winddirection_10m"),
                                jsonResponse.getJSONObject("current").getDouble("wind_gusts_10m")
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
                                hourlyTimeList,
                                temperature_2mList,
                                precipitation_probabilityList,
                                precipitationList,
                                rainList,
                                showersList,
                                snowfallList,
                                snow_depthList,
                                windspeed_10mList,
                                winddirection_10mList
                        ),
                        new DailyUnits(
                                jsonResponse.getJSONObject("daily_units").getString("time"),
                                jsonResponse.getJSONObject("daily_units").getString("temperature_2m_max"),
                                jsonResponse.getJSONObject("daily_units").getString("temperature_2m_min"),
                                jsonResponse.getJSONObject("daily_units").getString("sunrise"),
                                jsonResponse.getJSONObject("daily_units").getString("sunset"),
                                jsonResponse.getJSONObject("daily_units").getString("precipitation_sum"),
                                jsonResponse.getJSONObject("daily_units").getString("rain_sum"),
                                jsonResponse.getJSONObject("daily_units").getString("showers_sum"),
                                jsonResponse.getJSONObject("daily_units").getString("snowfall_sum"),
                                jsonResponse.getJSONObject("daily_units").getString("precipitation_hours")
                        ),
                        new Daily(
                                dailyTimeList,
                                temperature_2m_maxList,
                                temperature_2m_minList,
                                sunriseList,
                                sunsetList,
                                precipitation_sumList,
                                rain_sumList,
                                showers_sumList,
                                snowfall_sumList,
                                precipitation_hoursList
                        )
                );
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