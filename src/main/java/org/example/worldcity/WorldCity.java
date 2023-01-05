package org.example.worldcity;

import java.math.BigDecimal;

public class WorldCity {

    public int id;
    public String city;
    public String city_ascii;

    public BigDecimal lat; // Peut être remplacé par double?
    public BigDecimal lng; // Peut être remplacé par double?
    public String country;
    public String iso2;
    public String iso3;

    public WorldCity(String city, String city_ascii, BigDecimal lat, BigDecimal lng, String country, String iso2, String iso3) {
        this.city = city;
        this.city_ascii = city_ascii;
        this.lat = lat;
        this.lng = lng;
        this.country = country;
        this.iso2 = iso2;
        this.iso3 = iso3;
    }

    public WorldCity(int id, String city, String city_ascii, BigDecimal lat, BigDecimal lng, String country, String iso2, String iso3) {
        this.id = id;
        this.city = city;
        this.city_ascii = city_ascii;
        this.lat = lat;
        this.lng = lng;
        this.country = country;
        this.iso2 = iso2;
        this.iso3 = iso3;
    }

    public WorldCity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity_ascii() {
        return city_ascii;
    }

    public void setCity_ascii(String city_ascii) {
        this.city_ascii = city_ascii;
    }

    public BigDecimal getLat() {
        return lat;
    }

    public void setLat(BigDecimal lat) {
        this.lat = lat;
    }

    public BigDecimal getLng() {
        return lng;
    }

    public void setLng(BigDecimal lng) {
        this.lng = lng;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIso2() {
        return iso2;
    }

    public void setIso2(String iso2) {
        this.iso2 = iso2;
    }

    public String getIso3() {
        return iso3;
    }

    public void setIso3(String iso3) {
        this.iso3 = iso3;
    }

    @Override
    public String toString() {
        return "WorldCity{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", city_ascii='" + city_ascii + '\'' +
                ", lat=" + lat +
                ", lng=" + lng +
                ", country='" + country + '\'' +
                ", iso2='" + iso2 + '\'' +
                ", iso3='" + iso3 + '\'' +
                '}';
    }

}
