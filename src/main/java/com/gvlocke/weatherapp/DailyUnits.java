package com.gvlocke.weatherapp;

public record DailyUnits(String time, String weather_code, String temperature2mMax, String temperature2mMin, String sunrise, String sunset, String precipitationSum, String rainSum, String showersSum, String snowfallSum, String precipitationHours) {

    @Override
    public String toString() {
        return "DailyUnitsRecord{" +
                "time='" + time + '\'' +
                ", weather_code='" + weather_code + '\'' +
                ", temperature_2m_max='" + temperature2mMax + '\'' +
                ", temperature_2m_min='" + temperature2mMin + '\'' +
                ", sunrise='" + sunrise + '\'' +
                ", sunset='" + sunset + '\'' +
                ", precipitation_sum='" + precipitationSum + '\'' +
                ", rain_sum='" + rainSum + '\'' +
                ", showers_sum='" + showersSum + '\'' +
                ", snowfall_sum='" + snowfallSum + '\'' +
                ", precipitation_hours='" + precipitationHours + '\'' +
                '}';
    }
}
