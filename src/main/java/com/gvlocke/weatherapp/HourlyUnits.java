package com.gvlocke.weatherapp;
public record HourlyUnits (String time, String temperature_2m, String precipitation_probability, String precipitation, String rain, String showers, String snowfall, String snow_depth, String windspeed_10m, String winddirection_10m) {
    @Override
    public String toString() {
        return "HourlyUnits{" +
                "time='" + time + '\'' +
                ", temperature_2m='" + temperature_2m + '\'' +
                ", precipitation_probability='" + precipitation_probability + '\'' +
                ", precipitation='" + precipitation + '\'' +
                ", rain='" + rain + '\'' +
                ", showers='" + showers + '\'' +
                ", snowfall='" + snowfall + '\'' +
                ", snow_depth='" + snow_depth + '\'' +
                ", windspeed_10m='" + windspeed_10m + '\'' +
                ", winddirection_10m='" + winddirection_10m + '\'' +
                '}';
    }
}