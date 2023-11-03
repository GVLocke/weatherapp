package com.gvlocke.weatherapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainSceneController {
    @FXML
    Label timeLabel;

    @FXML
    Label locationLabel;

    @FXML
    Label currentWeatherLabel;

    private Weather weather;
    private Geolocation location;
    private String timestring;
    private String locationstring;

    public void setWeather(Weather weather) {
        this.weather = weather;
        this.timestring = weather.getCurrent().getTime();
    }

    public void setLocation(Geolocation location) {
        this.location = location;
        this.locationstring = location.getCity() + ", " + location.getRegionName() + ", " + location.getCountryCode();
    }

    public void displayTime() {
        timeLabel.setText(DateFormatter.format(this.timestring));
    }

    public void displayLocation() {
        locationLabel.setText(locationstring);
    }

    public void displayCurrentWeather() {
        currentWeatherLabel.setText(weather.getCurrentWeather());
    }

    public String getTimestring() {
        return timestring;
    }

    public String getLocationstring() {
        return locationstring;
    }
}