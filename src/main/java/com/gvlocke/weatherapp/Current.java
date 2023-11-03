package com.gvlocke.weatherapp;

public class Current {
    private String time;
    private int interval;
    private double temperature_2m;
    private double precipitation;
    private double rain;
    private double showers;
    private double snowfall;
    private double windspeed_10m;
    private double winddirection_10m;

    public Current(String time, int interval, double temperature_2m, double precipitation, double rain, double showers, double snowfall, double windspeed_10m, double winddirection_10m) {
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

    public int getInterval() {
        return interval;
    }

    public double getTemperature_2m() {
        return temperature_2m;
    }

    public double getPrecipitation() {
        return precipitation;
    }

    public double getRain() {
        return rain;
    }

    public double getShowers() {
        return showers;
    }

    public double getSnowfall() {
        return snowfall;
    }

    public double getWindspeed_10m() {
        return windspeed_10m;
    }

    public double getWinddirection_10m() {
        return winddirection_10m;
    }
}

