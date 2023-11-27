package com.gvlocke.weatherapp;

public class Current {
    private final String time;
    private final int interval;
    private final double temperature_2m;
    private final double precipitation;
    private final double rain;
    private final double showers;
    private final double snowfall;
    private final int weatherCode;
    private final double wind_speed_10m;
    private final double wind_direction_10m;
    private final double wind_gusts_10m;
    private final WeatherCodeMapper weatherCodeMapper = new WeatherCodeMapper();

    public Current(String time, int interval, double temperature_2m, double precipitation, double rain, double showers, double snowfall, int weatherCode, double wind_speed_10m, double wind_direction_10m, double wind_gusts_10m) {
        this.time = time;
        this.interval = interval;
        this.temperature_2m = temperature_2m;
        this.precipitation = precipitation;
        this.rain = rain;
        this.showers = showers;
        this.snowfall = snowfall;
        this.weatherCode = weatherCode;
        this.wind_speed_10m = wind_speed_10m;
        this.wind_direction_10m = wind_direction_10m;
        this.wind_gusts_10m = wind_gusts_10m;
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

    public int getWeatherCode() {
        return weatherCode;
    }

    public String getWeatherCodeString() {
        return weatherCodeMapper.getWeatherCode(weatherCode);
    }

    public double getWindspeed_10m() {
        return wind_speed_10m;
    }

    public double getWinddirection_10m() {
        return wind_direction_10m;
    }

    public double getWindgusts_10m() {
        return wind_gusts_10m;
    }

    @Override
    public String toString() {
        return "Current Weather:\n" +
                "Time: " + time + "\n" +
                "Interval: " + interval + "\n" +
                "Temperature (2m): " + temperature_2m + "°C\n" +
                "Precipitation: " + precipitation + " mm\n" +
                "Rain: " + rain + " mm\n" +
                "Showers: " + showers + " mm\n" +
                "Snowfall: " + snowfall + " cm\n" +
                "Weather Code:" + weatherCodeMapper.getWeatherCode(weatherCode) +
                "Windspeed (10m): " + wind_speed_10m + " m/s\n" +
                "Winddirection (10m): " + wind_direction_10m + "°";
    }
}

