package com.gvlocke.weatherapp;

import java.util.List;

public record Hourly(List<String> time, List<Double> temperature_2m, List<Double> precipitation_probability,
                     List<Double> precipitation, List<Double> rain, List<Double> showers, List<Double> snowfall,
                     List<Double> snow_depth, List<Double> windspeed_10m, List<Integer> winddirection_10m) {

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

