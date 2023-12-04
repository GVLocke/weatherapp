package com.gvlocke.weatherapp;

public record CurrentUnits(String time, String interval, String temperature_2m, String precipitation, String rain, String showers, String snowfall, String weatherCode, String windspeed_10m, String winddirection_10m, String windgusts_10m) {

    @Override
    public String toString() {
        return "CurrentUnits{" +
                "time='" + time + '\'' +
                ", interval='" + interval + '\'' +
                ", temperature_2m='" + temperature_2m + '\'' +
                ", precipitation='" + precipitation + '\'' +
                ", rain='" + rain + '\'' +
                ", showers='" + showers + '\'' +
                ", snowfall='" + snowfall + '\'' +
                ", weatherCode='" + weatherCode + '\'' +
                ", windspeed_10m='" + windspeed_10m + '\'' +
                ", winddirection_10m='" + winddirection_10m + '\'' +
                ", windgusts_10m='" + windgusts_10m + '\'' +
                '}';
    }
}