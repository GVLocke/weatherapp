package com.gvlocke.weatherapp;

import java.util.List;

public class Hourly {
    private final List<String> time;
    private final List<Number> temperature_2m;
    private final List<Double> precipitation_probability;
    private final List<Double> precipitation;
    private final List<Double> rain;
    private final List<Double> showers;
    private final List<Double> snowfall;
    private final List<Double> snow_depth;
    private final List<Integer> weatherCode;
    private final List<Number> windspeed_10m;
    private final List<Integer> winddirection_10m;
    private final List<Double> windgusts_10m;

    public Hourly(List<String> time, List<Number> temperature_2m, List<Double> precipitation_probability, List<Double> precipitation, List<Double> rain, List<Double> showers, List<Double> snowfall, List<Double> snow_depth, List<Integer> weatherCode, List<Number> windspeed_10m, List<Integer> winddirection_10m, List<Double> windgusts10m) {
        this.time = time;
        this.temperature_2m = temperature_2m;
        this.precipitation_probability = precipitation_probability;
        this.precipitation = precipitation;
        this.rain = rain;
        this.showers = showers;
        this.snowfall = snowfall;
        this.snow_depth = snow_depth;
        this.weatherCode = weatherCode;
        this.windspeed_10m = windspeed_10m;
        this.winddirection_10m = winddirection_10m;
        windgusts_10m = windgusts10m;
    }

    public List<String> getTime() {
        return time;
    }

    public List<Number> getTemperature_2m() {
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

    public List<Number> getWindspeed_10m() {
        return windspeed_10m;
    }

    public Double getAverageWindspeed_10m() {
        double sum = 0;
        for (Number n : windspeed_10m) {
            sum += n.doubleValue();
        }
        return sum / windspeed_10m.size();
    }

    public List<Integer> getWinddirection_10m() {
        return winddirection_10m;
    }

    public List<Integer> getWeatherCode() {
        return weatherCode;
    }

    public List<Double> getWindgusts_10m() {
        return windgusts_10m;
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

