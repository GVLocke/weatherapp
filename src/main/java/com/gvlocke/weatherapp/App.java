package com.gvlocke.weatherapp;

public class App {
    public static void main(String[] args) {
        Forcastor forcastor = new Forcastor();
        Weather weather = forcastor.getWeather();
        System.out.println(weather);
    }
}
