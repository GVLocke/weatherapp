package com.gvlocke.weatherapp;

public record Geolocation(String countryCode, String regionName, String city, double lat, double lon) {

    @Override
    public String toString() {
        return "Geolocation{" +
                "countryCode='" + countryCode + '\'' +
                ", regionName='" + regionName + '\'' +
                ", city='" + city + '\'' +
                ", lat='" + lat + '\'' +
                ", lon='" + lon + '\'' +
                '}';
    }
}
