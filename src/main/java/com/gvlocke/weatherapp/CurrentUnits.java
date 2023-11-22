package com.gvlocke.weatherapp;

public class CurrentUnits {
    private final String time;
    private final String interval;
    private final String temperature_2m;
    private final String precipitation;
    private final String rain;
    private final String showers;
    private final String snowfall;
    private final String weatherCode;
    private final String windspeed_10m;
    private final String winddirection_10m;
    private final String windgusts_10m;

    public CurrentUnits(String time, String interval, String temperature_2m, String precipitation, String rain, String showers, String snowfall, String weatherCode, String windspeed_10m, String winddirection_10m, String windgusts10m) {
        this.time = time;
        this.interval = interval;
        this.temperature_2m = temperature_2m;
        this.precipitation = precipitation;
        this.rain = rain;
        this.showers = showers;
        this.snowfall = snowfall;
        this.weatherCode = weatherCode;
        this.windspeed_10m = windspeed_10m;
        this.winddirection_10m = winddirection_10m;
        windgusts_10m = windgusts10m;
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
    public String getWeatherCode() {
        return weatherCode;
    }

    public String getWindspeed_10m() {
        return windspeed_10m;
    }

    public String getWinddirection_10m() {
        return winddirection_10m;
    }

    public String getWindgusts_10m() {
        return windgusts_10m;
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
                ", weatherCode='" + weatherCode + '\'' +
                ", windspeed_10m='" + windspeed_10m + '\'' +
                ", winddirection_10m='" + winddirection_10m + '\'' +
                ", windgusts_10m='" + windgusts_10m + '\'' +
                '}';
    }
}
