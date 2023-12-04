package com.gvlocke.weatherapp;

import java.util.HashMap;
import java.util.Map;

public class WeatherCodeMapper {
    private final Map<Integer, String> weatherCodeMap;

    public WeatherCodeMapper() {
        weatherCodeMap = new HashMap<>();
        initializeWeatherCodeMap();
    }

    private void initializeWeatherCodeMap() {
        weatherCodeMap.put(0, "Clear");                             // sunny
        weatherCodeMap.put(1, "Mainly Clear");                      // ..
        weatherCodeMap.put(2, "Partly Cloudy");                     // ..
        weatherCodeMap.put(3, "Cloudy");                            // cloudy
        weatherCodeMap.put(10, "Misty");                            // ..
        weatherCodeMap.put(36, "Light Blowing Snow");               // snow
        weatherCodeMap.put(37, "Heavy Drifting Snow");              // ..
        weatherCodeMap.put(41, "Patchy Fog");                       // sleet
        weatherCodeMap.put(42, "Light Thinning Fog");               // ..
        weatherCodeMap.put(43, "Heavy Thinning Fog");               // ..
        weatherCodeMap.put(44, "Light Fog");                        // ..
        weatherCodeMap.put(45, "Heavy Fog");                        // ..
        weatherCodeMap.put(46, "Light Thickening Fog");             // ..
        weatherCodeMap.put(47, "Heavy Thickening Fog");             // ..
        weatherCodeMap.put(48, "Light Freezing Fog");               // ..
        weatherCodeMap.put(49, "Heavy Freezing Fog");               // ..
        weatherCodeMap.put(51, "Light Drizzle");                    // rain-with-sun
        weatherCodeMap.put(53, "Moderate Drizzle");                 // ..
        weatherCodeMap.put(55, "Heavy Drizzle");                    // ..
        weatherCodeMap.put(61, "Light Rain");                       // rain
        weatherCodeMap.put(63, "Moderate Rain");                    // ..
        weatherCodeMap.put(65, "Heavy Rain");                       // ..
        weatherCodeMap.put(66, "Light Freezing Rain");              // wintry-mix
        weatherCodeMap.put(67, "Heavy Freezing Rain");              // ..
        weatherCodeMap.put(68, "Light Rain/Snow Mix");              // ..
        weatherCodeMap.put(69, "Light Rain/Snow Mix");              // ..
        weatherCodeMap.put(71, "Light Snow");                       // snow
        weatherCodeMap.put(73, "Moderate Snow");                    // ..
        weatherCodeMap.put(75, "Heavy Snow");                       // ..
        weatherCodeMap.put(76, "Light Snow Grains");                // ..
        weatherCodeMap.put(77, "Moderate Snow Grains");             // ..
        weatherCodeMap.put(78, "Heavy Snow Grains");                // ..
        weatherCodeMap.put(79, "Light Ice Crystals");               // ..
        weatherCodeMap.put(80, "Light Showers");                    // rain
        weatherCodeMap.put(81, "Moderate Showers");                 // ..
        weatherCodeMap.put(82, "Violent Showers");                  // ..
        weatherCodeMap.put(83, "Light Showers/Snow Mix");           // wintry-mix
        weatherCodeMap.put(84, "Heavy Rain/Snow Mix");              // ..
        weatherCodeMap.put(85, "Light Snow Showers");               // snow
        weatherCodeMap.put(86, "Moderate Snow Showers");            // ..
        weatherCodeMap.put(87, "Hail");                             // rain
        weatherCodeMap.put(88, "Heavy Hail");                       // ..
        weatherCodeMap.put(91, "Slight Rain");                      // ..
        weatherCodeMap.put(92, "Moderate Rain");                    // ..
        weatherCodeMap.put(93, "Slight Wintry Mix");                // wintry-mix
        weatherCodeMap.put(94, "Moderate Wintry Mix");              // ..
        weatherCodeMap.put(95, "Thunderstorm");                     // thunderstorms
        weatherCodeMap.put(96, "Thunderstorm with Hail");           // ..
        weatherCodeMap.put(97, "Heavy Thunderstorm");               // ..
        weatherCodeMap.put(98, "Thunderstorm with Dust/Sandstorm"); // ..
        weatherCodeMap.put(99, "Heavy Thunderstorm with Hail");     // ..
    }

    public String getWeatherCode(int weatherCode) {
        return weatherCodeMap.getOrDefault(weatherCode, "Unknown");
    }
}