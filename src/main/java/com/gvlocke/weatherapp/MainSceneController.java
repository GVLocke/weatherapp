package com.gvlocke.weatherapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

public class MainSceneController {
    @FXML
    private Label timeLabel;

    @FXML
    private Label locationLabel;

    @FXML
    private Label currentWeatherLabel;

    @FXML
    private Label currentTemperatureLabel;

    @FXML
    private Label weatherCodeLabel;

    @FXML
    private TextField locationTextField;

    @FXML
    private ImageView weatherIcon;

    @FXML
    private Label hiLowLabel;

    private Weather weather;
    private Geolocation location;
    private String timestring;
    private String locationstring;

    public MainSceneController() {
    }

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

    public void displayHiLowTemperature() {
        hiLowLabel.setText("L: " + weather.getDaily().getTemperature_2m_min().get(0)+ "°/H: " + weather.getDaily().getTemperature_2m_max().get(0) + "°");
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

    public void displayWeatherIcon(String iconPath) {
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(iconPath)));
        weatherIcon.setImage(image);
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
            displayWeatherIcon(getIconPath());
            displayHiLowTemperature();
        }
        else {
            System.out.println("An error occurred.");
        }
    }

    public String getIconPath() {
        String iconPath;
        switch (weather.getCurrent().getWeatherCode()) {
            case 0, 1 -> {
                if (weather.getCurrent().getWindspeed_10m() > 20){
                    iconPath = "/windy.png";
                }
                else if (weather.getCurrent().getIs_day() == 1) {
                    iconPath = "/sunny.png";
                }
                else {
                    iconPath = "/night.png";
                }
            }
            case 2 -> {
                if (weather.getCurrent().getWindspeed_10m() > 20){
                    iconPath = "/windy.png";
                }
                else if (weather.getCurrent().getIs_day() == 1) {
                    iconPath = "/partly-cloudy.png";
                }
                else {
                    iconPath = "/partly-cloudy-night.png";
                }
            }
            case 3, 10 -> {
                if (weather.getCurrent().getWindspeed_10m() > 20){
                    iconPath = "/windy.png";
                }
                else {
                    iconPath = "/cloudy.png";
                }
            }
            case 36, 37, 71, 73, 75, 85, 86 -> iconPath = "/snow.png";
            case 41, 42, 43, 44, 45, 46, 47, 48, 49 -> iconPath = "/sleet.png";
            case 51, 53, 55 -> {
                if (weather.getCurrent().getWindspeed_10m() > 20){
                    iconPath = "/windy-rain.png";
                }
                else if (weather.getCurrent().getIs_day() == 1) {
                    iconPath = "/rain-with-sun.png";
                }
                else {
                    iconPath = "/rain-night.png";
                }
            }
            case 61, 63, 65, 80, 81, 82, 87, 88, 91, 92 -> {
                if (weather.getCurrent().getWindspeed_10m() > 20){
                    iconPath = "/windy-rain.png";
                }
                else if (weather.getCurrent().getIs_day() == 1) {
                    iconPath = "/rain.png";
                }
                else {
                    iconPath = "/rain-night.png";
                }
            }
            case 66, 67, 68, 69, 83, 84, 93, 94 -> iconPath = "/wintry-mix.png";
            case 95, 96, 97, 98, 99 -> iconPath = "/thunderstorms.png";
            default -> iconPath = "/unknown.png";
        }
        return iconPath;
    }
}