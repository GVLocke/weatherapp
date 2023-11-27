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
        Geolocation geolocation = getLocation();
        if (geolocation != null) {
            controller.setWeather(new Forecaster().getWeather(geolocation));
            controller.setLocation(geolocation);
            controller.displayCurrentTemperature();
            controller.displayTime();
            controller.displayLocation();
            controller.displayCurrentWeather();
            controller.displayWeatherCode();
//            stage.setTitle("Weather for " + controller.getLocationstring());
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

    public static Geolocation getLocation() {
        Scanner input = new Scanner(System.in);
        System.out.println("1. Use current location");
        System.out.println("2. Search for a location");
        System.out.print("Choose an option: ");
        int selection = input.nextInt();
        // consume the newline character
        input.nextLine();
        if (selection == 1) {
            Locator locator = new Locator();
            return locator.getGeolocation();
        }
        if (selection == 2) {
            System.out.print("Enter the name of a place (or an address): ");
            String placeName = input.nextLine();
            input.close();
            String apiKey = getApiKey();
            Geocoder geocoder = new Geocoder(apiKey);
            return geocoder.getGeolocation(placeName);
        }
        return null;
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