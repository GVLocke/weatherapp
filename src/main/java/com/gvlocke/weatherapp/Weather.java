package com.gvlocke.weatherapp;

import java.time.LocalDateTime;

public class Weather {
    private final double latitude;
    private final double longitude;
    private final double generationtime_ms;
    private final int utc_offset_seconds;
    private final String timezone;
    private final String timezone_abbreviation;
    private final double elevation;
    private final CurrentUnits current_units;
    private final Current current;
    private final HourlyUnits hourly_units;
    private final Hourly hourly;
    private final DailyUnits daily_units;
    private final Daily daily;
    public final LocalDateTime TODAY_SUNRISE;
    public final LocalDateTime TODAY_SUNSET;
    public final LocalDateTime TOMORROW_SUNRISE;
    public final LocalDateTime TOMORROW_SUNSET;

    public Weather(double latitude, double longitude, double generationtime_ms, int utc_offset_seconds, String timezone, String timezone_abbreviation, double elevation, CurrentUnits current_units, Current current, HourlyUnits hourly_units, Hourly hourly, DailyUnits dailyUnits, Daily daily) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.generationtime_ms = generationtime_ms;
        this.utc_offset_seconds = utc_offset_seconds;
        this.timezone = timezone;
        this.timezone_abbreviation = timezone_abbreviation;
        this.elevation = elevation;
        this.current_units = current_units;
        this.current = current;
        this.hourly_units = hourly_units;
        this.hourly = hourly;
        daily_units = dailyUnits;
        this.daily = daily;
        this.TODAY_SUNRISE = LocalDateTime.parse(this.daily.sunrise().get(0));
        this.TODAY_SUNSET = LocalDateTime.parse(this.daily.sunset().get(0));
        this.TOMORROW_SUNRISE = LocalDateTime.parse(this.daily.sunrise().get(1));
        this.TOMORROW_SUNSET = LocalDateTime.parse(this.daily.sunset().get(1));
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getGenerationtime_ms() {
        return generationtime_ms;
    }

    public int getUtc_offset_seconds() {
        return utc_offset_seconds;
    }

    public String getTimezone() {
        return timezone;
    }

    public String getTimezone_abbreviation() {
        return timezone_abbreviation;
    }

    public double getElevation() {
        return elevation;
    }

    public CurrentUnits getCurrent_units() {
        return current_units;
    }

    public Current getCurrent() {
        return current;
    }

    public HourlyUnits getHourly_units() {
        return hourly_units;
    }

    public Hourly getHourly() {
        return hourly;
    }

    public String getCurrentWeather() {
        // TODO: Turn Wind Direction Units to Cardinal Directions. The API can only return degrees.
        String day;
        if (this.current.getIs_day() == 1) {
            day = "Day";
        }
        else {
            day = "Night";
        }
        return "Current Weather:\n" +
                "Temperature (2m): " + this.current.getTemperature_2m() + " " + this.current_units.temperature_2m() + "\n" +
                "Is Day: " + day + "\n" +
                "Precipitation: " + this.current.getPrecipitation() + " " + this.current_units.precipitation() + "\n" +
                "Rain: " + this.current.getRain() + " " + this.current_units.rain() + "\n" +
                "Showers: " + this.current.getShowers() + " " + this.current_units.showers() + "\n" +
                "Snowfall: " + this.current.getSnowfall() + " " + this.current_units.snowfall() + "\n" +
                "Weather Code: " + this.current.getWeatherCode() + "\n" +
                "Wind Speed (10m): " + this.current.getWindspeed_10m() + " " + this.current_units.windspeed_10m() + "\n" +
                "Wind Direction (10m): " + this.current.getWinddirection_10m() + " " + this.current_units.winddirection_10m() + "\n" +
                "Wind Gusts (10m): " + this.current.getWindgusts_10m() + " " + this.current_units.windgusts_10m();
    }

    @Override
    public String toString() {
        return "Weather{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", generationtime_ms=" + generationtime_ms +
                ", utc_offset_seconds=" + utc_offset_seconds +
                ", timezone='" + timezone + '\'' +
                ", timezone_abbreviation='" + timezone_abbreviation + '\'' +
                ", elevation=" + elevation +
                ", current_units=" + current_units +
                ", current=" + current +
                ", hourly_units=" + hourly_units +
                ", hourly=" + hourly +
                '}';
    }

    public DailyUnits getDaily_units() {
        return daily_units;
    }

    public Daily getDaily() {
        return daily;
    }
}