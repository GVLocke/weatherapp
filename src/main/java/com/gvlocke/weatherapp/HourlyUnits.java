package com.gvlocke.weatherapp;

public class HourlyUnits {
    private String time;
    private String temperature_2m;
    private String precipitation_probability;
    private String precipitation;
    private String rain;
    private String showers;
    private String snowfall;
    private String snow_depth;
    private String windspeed_10m;
    private String winddirection_10m;

    public HourlyUnits(String time, String temperature_2m, String precipitation_probability, String precipitation, String rain, String showers, String snowfall, String snow_depth, String windspeed_10m, String winddirection_10m) {
        this.time = time;
        this.temperature_2m = temperature_2m;
        this.precipitation_probability = precipitation_probability;
        this.precipitation = precipitation;
        this.rain = rain;
        this.showers = showers;
        this.snowfall = snowfall;
        this.snow_depth = snow_depth;
        this.windspeed_10m = windspeed_10m;
        this.winddirection_10m = winddirection_10m;
    }

    public String getTime() {
        return time;
    }

    public String getTemperature_2m() {
        return temperature_2m;
    }

    public String getPrecipitation_probability() {
        return precipitation_probability;
    }

    public String getPrecipitation() {
        return precipitation;
    }

    public String getRain() {
        return rain;
    }

    public String getShowers() {
        return showers;
    }

    public String getSnowfall() {
        return snowfall;
    }

    public String getSnow_depth() {
        return snow_depth;
    }

    public String getWindspeed_10m() {
        return windspeed_10m;
    }

    public String getWinddirection_10m() {
        return winddirection_10m;
    }

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
