package com.gvlocke.weatherapp;

import java.util.Scanner;

public class DriverClass {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the name of a city: ");
        String placeName = input.nextLine();
        double[] latLong = Geocoder.getLatLong(placeName);
        if (latLong != null) {
            System.out.println("Latitude: " + latLong[0]);
            System.out.println("Longitude: " + latLong[1]);
        } else {
            System.out.println("An error occurred.");
        }
    }
}
