package com.gvlocke.weatherapp;
import java.util.List;

public class Daily {
    private final List<String> time;
    private final List<Double> temperature_2m_max;
    private final List<Double> temperature_2m_min;
    private final List<String> sunrise;
    private final List<String> sunset;
    private final List<Double> precipitation_sum;
    private final List<Double> rain_sum;
    private final List<Double> showers_sum;
    private final List<Double> snowfall_sum;
    private final List<Double> precipitation_hours;

    public Daily(List<String> time, List<Double> temperature_2m_max, List<Double> temperature_2m_min, List<String> sunrise, List<String> sunset, List<Double> precipitation_sum, List<Double> rain_sum, List<Double> showers_sum, List<Double> snowfall_sum, List<Double> precipitation_hours) {
        this.time = time;
        this.temperature_2m_max = temperature_2m_max;
        this.temperature_2m_min = temperature_2m_min;
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.precipitation_sum = precipitation_sum;
        this.rain_sum = rain_sum;
        this.showers_sum = showers_sum;
        this.snowfall_sum = snowfall_sum;
        this.precipitation_hours = precipitation_hours;
    }

    public List<String> getTime() {
        return time;
    }

    public List<Double> getTemperature_2m_max() {
        return temperature_2m_max;
    }

    public List<Double> getTemperature_2m_min() {
        return temperature_2m_min;
    }

    public List<String> getSunrise() {
        return sunrise;
    }

    public List<String> getSunset() {
        return sunset;
    }

    public List<Double> getPrecipitation_sum() {
        return precipitation_sum;
    }

    public List<Double> getRain_sum() {
        return rain_sum;
    }

    public List<Double> getShowers_sum() {
        return showers_sum;
    }

    public List<Double> getSnowfall_sum() {
        return snowfall_sum;
    }

    public List<Double> getPrecipitation_hours() {
        return precipitation_hours;
    }

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
