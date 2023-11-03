package com.gvlocke.weatherapp;

public class CurrentUnits {
    private String time;
    private String interval;
    private String temperature_2m;
    private String precipitation;
    private String rain;
    private String showers;
    private String snowfall;
    private String windspeed_10m;
    private String winddirection_10m;

    public CurrentUnits(String time, String interval, String temperature_2m, String precipitation, String rain, String showers, String snowfall, String windspeed_10m, String winddirection_10m) {
        this.time = time;
        this.interval = interval;
        this.temperature_2m = temperature_2m;
        this.precipitation = precipitation;
        this.rain = rain;
        this.showers = showers;
        this.snowfall = snowfall;
        this.windspeed_10m = windspeed_10m;
        this.winddirection_10m = winddirection_10m;
    }

    public String getTime() {
        return time;
    }

    public String getInterval() {
        return interval;
    }

    public String getTemperature_2m() {
        return temperature_2m;
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

    public String getWindspeed_10m() {
        return windspeed_10m;
    }

    public String getWinddirection_10m() {
        return winddirection_10m;
    }

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
                ", windspeed_10m='" + windspeed_10m + '\'' +
                ", winddirection_10m='" + winddirection_10m + '\'' +
                '}';
    }
}
