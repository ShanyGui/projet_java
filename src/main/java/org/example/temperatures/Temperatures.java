package org.example.temperatures;

import org.example.connection.ConnectionOpenWeather;

import java.math.BigDecimal;
import java.util.Date;

public class Temperatures {
    int id;
    Date timestamp;
    String city;
    BigDecimal temperature;

    public Temperatures(int id, Date timestamp, double lat, double lng) {
        this.id = id;
        this.timestamp = timestamp;
        this.city = ConnectionOpenWeather.getCity(lat,lng);
        this.temperature = BigDecimal.valueOf(ConnectionOpenWeather.getTemperature(lat,lng));
    }

    public Temperatures(Date timestamp, double lat, double lng) {
        this.timestamp = timestamp;
        this.city = ConnectionOpenWeather.getCity(lat,lng);
        this.temperature = BigDecimal.valueOf(ConnectionOpenWeather.getTemperature(lat,lng));
    }

    public Temperatures(int id, Date timestamp, String city, BigDecimal temperature) {
        this.id = id;
        this.timestamp = timestamp;
        this.city = city;
        this.temperature = temperature;
    }
    public Temperatures(Date timestamp, String city) {
        this.timestamp = timestamp;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public BigDecimal getTemperature() {
        return temperature;
    }

    public void setTemperature(BigDecimal temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "Temperatures{" +
                "id=" + id +
                ", timestamp=" + timestamp +
                ", city='" + city + '\'' +
                ", temperature=" + temperature +
                '}';
    }
}
