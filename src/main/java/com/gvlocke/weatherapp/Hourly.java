package com.gvlocke.weatherapp;
import java.util.ArrayList;
import java.util.List;

public class Hourly {
    private List<String> time;
    private List<Double> temperature_2m;
    private List<Double> precipitation_probability;
    private List<Double> precipitation;
    private List<Double> rain;
    private List<Double> showers;
    private List<Double> snowfall;
    private List<Double> snow_depth;
    private List<Double> windspeed_10m;
    private List<Integer> winddirection_10m;

    public Hourly(List<String> time, List<Double> temperature_2m, List<Double> precipitation_probability, List<Double> precipitation, List<Double> rain, List<Double> showers, List<Double> snowfall, List<Double> snow_depth, List<Double> windspeed_10m, List<Integer> winddirection_10m) {
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

    public List<String> getTime() {
        return time;
    }

    public List<Double> getTemperature_2m() {
        return temperature_2m;
    }

    public List<Double> getPrecipitation_probability() {
        return precipitation_probability;
    }

    public List<Double> getPrecipitation() {
        return precipitation;
    }

    public List<Double> getRain() {
        return rain;
    }

    public List<Double> getShowers() {
        return showers;
    }

    public List<Double> getSnowfall() {
        return snowfall;
    }

    public List<Double> getSnow_depth() {
        return snow_depth;
    }

    public List<Double> getWindspeed_10m() {
        return windspeed_10m;
    }

    public List<Integer> getWinddirection_10m() {
        return winddirection_10m;
    }

    @Override
    public String toString() {
        return "Hourly{" +
                "time=" + time +
                ", temperature_2m=" + temperature_2m +
                ", precipitation_probability=" + precipitation_probability +
                ", precipitation=" + precipitation +
                ", rain=" + rain +
                ", showers=" + showers +
                ", snowfall=" + snowfall +
                ", snow_depth=" + snow_depth +
                ", windspeed_10m=" + windspeed_10m +
                ", winddirection_10m=" + winddirection_10m +
                '}';
    }
}

