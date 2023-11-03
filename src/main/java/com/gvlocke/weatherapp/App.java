package com.gvlocke.weatherapp;

import com.gvlocke.Forcastor;

public class App {
    public static void main(String[] args) {
        Forcastor forcastor = new Forcastor();
        Weather weather = forcastor.getWeather();
        System.out.println(weather);
    }
}
