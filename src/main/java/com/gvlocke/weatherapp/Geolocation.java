package com.gvlocke.weatherapp;

public class Geolocation {
    private String status;
    private String countryCode;
    private String regionName;
    private String city;
    private double lat;
    private double lon;
    private String timezone;

    public Geolocation(String status, String countryCode, String regionName, String city, double lat, double lon, String timezone) {
        this.status = status;
        this.countryCode = countryCode;
        this.regionName = regionName;
        this.city = city;
        this.lat = lat;
        this.lon = lon;
        this.timezone = timezone;
    }

    public String getStatus() {
        return status;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getRegionName() {
        return regionName;
    }

    public String getCity() {
        return city;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public String getTimezone() {
        return timezone;
    }

    public String getURLTimezone() {
        return timezone.replace("/", "%2F");
    }

    @Override
    public String toString() {
        return "Geolocation{" +
                "status='" + status + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", regionName='" + regionName + '\'' +
                ", city='" + city + '\'' +
                ", lat='" + lat + '\'' +
                ", lon='" + lon + '\'' +
                ", timezone='" + timezone + '\'' +
                '}';
    }
}
