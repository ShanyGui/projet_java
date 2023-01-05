package org.example;

import org.example.connection.ConnectionOpenWeather;

public class Main {
    public static void main(String[] args) {

        System.out.println(ConnectionOpenWeather.getTemperature(43.29, 5.36));

    }
}