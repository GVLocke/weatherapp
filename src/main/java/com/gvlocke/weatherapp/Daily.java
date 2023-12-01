package com.gvlocke.weatherapp;
import java.util.List;

public record Daily(List<String> time, List<Double> temperature_2m_max, List<Double> temperature_2m_min,
                    List<String> sunrise, List<String> sunset, List<Double> precipitation_sum, List<Double> rain_sum,
                    List<Double> showers_sum, List<Double> snowfall_sum, List<Double> precipitation_hours) {

    @Override
    public String toString() {
        return "Daily{" +
                "time=" + time +
                ", temperature_2m_max=" + temperature_2m_max +
                ", temperature_2m_min=" + temperature_2m_min +
                ", sunrise=" + sunrise +
                ", sunset=" + sunset +
                ", precipitation_sum=" + precipitation_sum +
                ", rain_sum=" + rain_sum +
                ", showers_sum=" + showers_sum +
                ", snowfall_sum=" + snowfall_sum +
                ", precipitation_hours=" + precipitation_hours +
                '}';
    }
}
