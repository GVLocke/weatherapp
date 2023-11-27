package com.gvlocke.weatherapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainSceneController {
    @FXML
    Label timeLabel;

    @FXML
    Label locationLabel;

    @FXML
    Label currentWeatherLabel;

    @FXML
    Label currentTemperatureLabel;

    @FXML
    Label weatherCodeLabel;

    @FXML
    TextField locationTextField;

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
        this.locationstring = location.city() + ", " + location.regionName() + ", " + location.countryCode();
    }

    public void displayCurrentTemperature() {
        currentTemperatureLabel.setText((int) weather.getCurrent().getTemperature_2m() + "°");
    }

    public void displayWeatherCode() {
        WeatherCodeMapper weatherCodeMapper = new WeatherCodeMapper();
        weatherCodeLabel.setText(weatherCodeMapper.getWeatherCode(weather.getCurrent().getWeatherCode()));
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

    public void searchLocation() {
        String location = locationTextField.getText();
        String apiKey = WeatherApp.getApiKey();
        Geocoder geocoder = new Geocoder(apiKey);
        Geolocation geolocation = geocoder.getGeolocation(location);
        if (geolocation != null) {
            this.location = geolocation;
            this.locationstring = geolocation.city() + ", " + geolocation.regionName() + ", " + geolocation.countryCode();
            this.weather = new Forecaster().getWeather(geolocation);
            this.timestring = weather.getCurrent().getTime();
            displayCurrentTemperature();
            displayTime();
            displayLocation();
            displayCurrentWeather();
            displayWeatherCode();
        }
        else {
            System.out.println("An error occurred.");
        }
    }
}