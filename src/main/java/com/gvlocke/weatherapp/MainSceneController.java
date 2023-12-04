package com.gvlocke.weatherapp;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.jetbrains.annotations.NotNull;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class MainSceneController {
    @FXML
    private Label timeLabel;

    @FXML
    private Label locationLabel;

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

    @FXML
    private HBox scrollBox;

    @FXML
    private VBox SevenDayForecastBox;

    @FXML
    private BorderPane SevenDayForecastBorderPane;

    @FXML
    private Label windSpeedLabel;

    @FXML
    private Label windSpeedUnitsLabel;

    @FXML
    private Label windDirectionLabel;

    @FXML
    private Label windGustsLabel;

    @FXML
    private Label windGustsUnitsLabel;

    @FXML
    private Label precipitationLabel;

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
        hiLowLabel.setText("L: " + weather.getDaily().temperature_2m_min().get(0)+ "°/H: " + weather.getDaily().temperature_2m_max().get(0) + "°");
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
            if (Objects.equals(this.weather.getCurrent_units().temperature_2m(), "°C")) {
                this.weather = new Forecaster().getWeather(this.location, "mph", "celsius", "inch");
            }
            else {
                this.weather = new Forecaster().getWeather(this.location);
            }
            this.timestring = weather.getCurrent().getTime();
            displayWeatherGUIComponents();
        }
        else {
            System.out.println("An error occurred.");
        }
    }

    public String getIconPath(int weathercode, double windspeed, int is_day) {
        String iconPath;
        switch (weathercode) {
            case 0, 1 -> {
                if (windspeed > 20){
                    iconPath = "/windy.png";
                }
                else if (is_day == 1) {
                    iconPath = "/sunny.png";
                }
                else {
                    iconPath = "/night.png";
                }
            }
            case 2 -> {
                if (windspeed > 20){
                    iconPath = "/windy.png";
                }
                else if (is_day == 1) {
                    iconPath = "/partly-cloudy.png";
                }
                else {
                    iconPath = "/partly-cloudy-night.png";
                }
            }
            case 3, 10 -> {
                if (windspeed > 20){
                    iconPath = "/windy.png";
                }
                else {
                    iconPath = "/cloudy.png";
                }
            }
            case 36, 37, 71, 73, 75, 76, 77, 78, 79, 85, 86 -> iconPath = "/snow.png";
            case 41, 42, 43, 44, 45, 46, 47, 48, 49 -> iconPath = "/sleet.png";
            case 51, 53, 55 -> {
                if (windspeed > 20){
                    iconPath = "/windy-rain.png";
                }
                else if (is_day == 1) {
                    iconPath = "/rain-with-sun.png";
                }
                else {
                    iconPath = "/rain-night.png";
                }
            }
            case 61, 63, 65, 80, 81, 82, 87, 88, 91, 92 -> {
                if (windspeed > 20){
                    iconPath = "/windy-rain.png";
                }
                else if (is_day == 1) {
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

    public void initializeSevenDayForecast() {
        SevenDayForecastBorderPane.setPadding(new Insets(10, 10, 10, 10));
        SevenDayForecastBorderPane.setCenter(SevenDayForecastBox);
        SevenDayForecastBorderPane.setStyle("-fx-border-color: grey;" + "-fx-border-radius: 10;" + "-fx-border-width: 2;" + "-fx-background-radius: 10;");
        SevenDayForecastBox.getChildren().clear();
        Label main_label = new Label("7 Day Forecast");
        SevenDayForecastBox.getChildren().add(main_label);
        SevenDayForecastBox.setAlignment(Pos.TOP_CENTER);
        // iterate through the next 7 days
        for (int i = 0; i < 7; i++) {
            HBox hbox = new HBox();
            SevenDayForecastBox.setSpacing(10); // Set the desired spacing
            Label info_label = new Label();
            ImageView weather_icon = new ImageView();
            String iconPath = getIconPath(weather.getDaily().weather_code().get(i), weather.getHourly().getAverageWindspeed_10m(), getIsDay(i));
            Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(iconPath)));
            weather_icon.setImage(image);
            weather_icon.setFitHeight(20);
            weather_icon.setFitWidth(20);
            String info_label_string = getSevenDayForecastString(i);
            info_label.setText(info_label_string);
            hbox.getChildren().addAll(weather_icon, info_label);
            SevenDayForecastBox.getChildren().add(hbox);
        }
    }

    public void initializeScrollbar() {
        scrollBox.getChildren().clear();
        // iterate through the next 24 hours
        for (int i = 1; i < 25; i++) {
            VBox vbox = new VBox();
            scrollBox.setSpacing(10); // Set the desired spacing
            vbox.setMaxSize(100, 75);
            vbox.setPadding(new Insets(5, 2, 5, 2)); // Set top, right, bottom, left insets
            vbox.setAlignment(javafx.geometry.Pos.CENTER);
            Label time_label = new Label();
            Label temp_label = new Label();
            ImageView weather_icon = new ImageView();
            // check if the current hour is day or night based on weather.getTodaySunrise() and weather.getTodaySunset()
            int is_day = getIsDay(i);
            String iconPath = getIconPath(weather.getHourly().getWeatherCode().get(i), weather.getHourly().getWindspeed_10m().get(i).doubleValue(), is_day);
            // format text as hour:minute
            if (i == 1) {
                time_label.setText("Now");
            }
            else {
                time_label.setText(weather.getHourly().getTime().get(i).substring(11, 13));
            }
            temp_label.setText(weather.getHourly().getTemperature_2m().get(i).intValue() + "°");
            Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(iconPath)));
            weather_icon.setImage(image);
            weather_icon.setFitHeight(40);
            weather_icon.setFitWidth(40);
            vbox.getChildren().addAll(time_label, weather_icon, temp_label);
            scrollBox.getChildren().add(vbox);
        }
    }

    public void initializeWindModule() {
        windSpeedLabel.prefWidthProperty().bind(windGustsLabel.widthProperty());
        windSpeedLabel.setText((int) weather.getCurrent().getWindspeed_10m() + "");
        windSpeedUnitsLabel.setText(weather.getCurrent_units().windspeed_10m());
        if (weather.getCurrent().getWinddirection_10m() >= 0 && weather.getCurrent().getWinddirection_10m() < 22.5) {
            windDirectionLabel.setText("N");
        }
        else if (weather.getCurrent().getWinddirection_10m() >= 22.5 && weather.getCurrent().getWinddirection_10m() < 67.5) {
            windDirectionLabel.setText("NE");
        }
        else if (weather.getCurrent().getWinddirection_10m() >= 67.5 && weather.getCurrent().getWinddirection_10m() < 112.5) {
            windDirectionLabel.setText("E");
        }
        else if (weather.getCurrent().getWinddirection_10m() >= 112.5 && weather.getCurrent().getWinddirection_10m() < 157.5) {
            windDirectionLabel.setText("SE");
        }
        else if (weather.getCurrent().getWinddirection_10m() >= 157.5 && weather.getCurrent().getWinddirection_10m() < 202.5) {
            windDirectionLabel.setText("S");
        }
        else if (weather.getCurrent().getWinddirection_10m() >= 202.5 && weather.getCurrent().getWinddirection_10m() < 247.5) {
            windDirectionLabel.setText("SW");
        }
        else if (weather.getCurrent().getWinddirection_10m() >= 247.5 && weather.getCurrent().getWinddirection_10m() < 292.5) {
            windDirectionLabel.setText("W");
        }
        else if (weather.getCurrent().getWinddirection_10m() >= 292.5 && weather.getCurrent().getWinddirection_10m() < 337.5) {
            windDirectionLabel.setText("NW");
        }
        else if (weather.getCurrent().getWinddirection_10m() >= 337.5 && weather.getCurrent().getWinddirection_10m() <= 360) {
            windDirectionLabel.setText("N");
        }
        else {
            windDirectionLabel.setText("Unknown");
        }
        windGustsLabel.setText((int) weather.getCurrent().getWindgusts_10m() + "");
        windGustsUnitsLabel.setText(weather.getCurrent_units().windgusts_10m());
    }

    public void initializePrecipitationModule() {

        if (Objects.equals(weather.getCurrent_units().precipitation(), "inch")) {
            precipitationLabel.setText(weather.getDaily().precipitation_sum().get(0).intValue() + "\"");
        }
        else if (Objects.equals(weather.getCurrent_units().precipitation(), "mm")) {
            precipitationLabel.setText(weather.getDaily().precipitation_sum().get(0).intValue() + "mm");
        }
    }
    public void switchTempUnit() {
        Forecaster forecaster = new Forecaster();
        System.out.println(this.weather.getCurrent_units().temperature_2m());
        if (Objects.equals(this.weather.getCurrent_units().temperature_2m(), "°F")) {
            this.weather = forecaster.getWeather(this.location, "mph", "celsius", "inch");
            displayWeatherGUIComponents();
            // exit the function early to prevent the next if statement from running
            return;
        }
        if (Objects.equals(this.weather.getCurrent_units().temperature_2m(), "°C")) {
            this.weather = forecaster.getWeather(this.location, "mph", "fahrenheit", "inch");
            displayWeatherGUIComponents();
        }
    }

    private int getIsDay(int i) {
        int is_day;
        LocalDateTime this_hour = LocalDateTime.parse(weather.getHourly().getTime().get(i));
        if (this_hour.isAfter(weather.TODAY_SUNRISE) && this_hour.isBefore(weather.TODAY_SUNSET) || this_hour.isAfter(weather.TOMORROW_SUNRISE) && this_hour.isBefore(weather.TOMORROW_SUNSET)) {
            is_day = 1;
        }
        else {
            is_day = 0;
        }
        return is_day;
    }

    private void displayWeatherGUIComponents() {
        displayCurrentTemperature();
        displayTime();
        displayLocation();
        displayWeatherCode();
        displayWeatherIcon(getIconPath(weather.getCurrent().getWeatherCode(), weather.getCurrent().getWindspeed_10m(), weather.getCurrent().getIs_day()));
        displayHiLowTemperature();
        initializeScrollbar();
        initializeSevenDayForecast();
        initializeWindModule();
        initializePrecipitationModule();
    }

    @NotNull
    private String getSevenDayForecastString(int i) {
        String info_label_string;
        if (i == 0) {
            info_label_string = "Today";
        } else {
            LocalDate this_day = LocalDate.parse(weather.getDaily().time().get(i));
            DayOfWeek dayOfWeek = this_day.getDayOfWeek();
            info_label_string = dayOfWeek.toString();
            info_label_string = info_label_string.substring(0, 1).toUpperCase() + info_label_string.substring(1).toLowerCase();
        }
        info_label_string += " | " + weather.getDaily().temperature_2m_min().get(i).intValue() + "°/" + weather.getDaily().temperature_2m_max().get(i).intValue() + "°";
        return info_label_string;
    }
}