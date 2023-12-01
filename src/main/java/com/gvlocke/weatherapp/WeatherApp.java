package com.gvlocke.weatherapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class WeatherApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(WeatherApp.class.getResource("MainScene.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        MainSceneController controller = fxmlLoader.getController();
        Locator locator = new Locator();
        Geolocation geolocation = locator.getGeolocation();
        if (geolocation != null) {
            controller.setWeather(new Forecaster().getWeather(geolocation));
            controller.setLocation(geolocation);
            controller.displayCurrentTemperature();
            controller.displayTime();
            controller.displayLocation();
            controller.displayCurrentWeather();
            controller.displayWeatherCode();
            controller.displayWeatherIcon(controller.getIconPath());
            controller.displayHiLowTemperature();
            stage.setScene(scene);
            stage.show();
        }
        else {
            System.out.println("An error occurred.");
        }
    }

    public static void main(String[] args) {
        launch();
    }

    public static String getApiKey() {
        File apiFile = new File("apikey.txt");
        String apiKey = "";
        try {
            Scanner fileReader = new Scanner(apiFile);
            apiKey = fileReader.nextLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return apiKey;
    }
}