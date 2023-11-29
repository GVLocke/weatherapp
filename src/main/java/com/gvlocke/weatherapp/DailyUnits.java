package com.gvlocke.weatherapp;

public class DailyUnits {
    private final String time;
    private final String temperature_2m_max;
    private final String temperature_2m_min;
    private final String sunrise;
    private final String sunset;
    private final String precipitation_sum;
    private final String rain_sum;
    private final String showers_sum;
    private final String snowfall_sum;
    private final String precipitation_hours;

    public DailyUnits(String time, String temperature2mMax, String temperature2mMin, String sunrise, String sunset, String precipitationSum, String rainSum, String showersSum, String snowfallSum, String precipitationHours) {
        this.time = time;
        temperature_2m_max = temperature2mMax;
        temperature_2m_min = temperature2mMin;
        this.sunrise = sunrise;
        this.sunset = sunset;
        precipitation_sum = precipitationSum;
        rain_sum = rainSum;
        showers_sum = showersSum;
        snowfall_sum = snowfallSum;
        precipitation_hours = precipitationHours;
    }

    public String getSunset() {
        return sunset;
    }

    public String getSunrise() {
        return sunrise;
    }

    public String getTime() {
        return time;
    }

    public String getTemperature_2m_min() {
        return temperature_2m_min;
    }

    public String getTemperature_2m_max() {
        return temperature_2m_max;
    }

    public String getPrecipitation_sum() {
        return precipitation_sum;
    }

    public String getRain_sum() {
        return rain_sum;
    }

    public String getShowers_sum() {
        return showers_sum;
    }

    public String getSnowfall_sum() {
        return snowfall_sum;
    }

    public String getPrecipitation_hours() {
        return precipitation_hours;
    }
}
