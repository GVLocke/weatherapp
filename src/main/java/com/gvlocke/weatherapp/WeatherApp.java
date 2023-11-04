package com.gvlocke.weatherapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class WeatherApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(WeatherApp.class.getResource("MainScene.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        MainSceneController controller = fxmlLoader.getController();
        controller.setWeather(new Forecaster().getWeather());
        controller.setLocation(new Locator().getLocation());
        controller.displayTime();
        controller.displayLocation();
        controller.displayCurrentWeather();
        stage.setTitle("Weather for " + controller.getLocationstring());
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}