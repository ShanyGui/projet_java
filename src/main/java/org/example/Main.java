package org.example;

import org.example.connection.ConnectionOpenWeather;
import org.example.temperatures.Temperatures;
import org.example.temperatures.TemperaturesCRUD;
import org.example.worldcity.WorldCity;
import org.example.worldcity.WorldCityCRUD;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.math.BigDecimal;

import java.util.Scanner;
import java.util.Scanner.*;

public class Main {
    public static void main(String[] args) throws ParseException {
        System.out.println("Initialisation");
        System.out.println("Veuillez choisir l'opération à réaliser : \n 1- Connaître la température d'un point du globe " +
                "\n 2- Lire et enregistrer la température d'un point du globe");
        Scanner scanner = new Scanner(System.in);
        int choix = scanner.nextInt();
        switch(choix){
            case 1:
                double lat;
                double lng;
                System.out.println("Entrez la latitude ( Attention utilisez une virgule )");
                lat = scanner.nextDouble();
                System.out.println("Entrez la longitude ( Attention utilisez une virgule )");
                lng = scanner.nextDouble();
                System.out.println("A : " + ConnectionOpenWeather.getCity(lat,lng));
                System.out.println("La température est de : " + ConnectionOpenWeather.getTemperature(lat,lng) + " °C");
        }
        switch(choix){
            case 2:
                double lat;
                double lng;
                String date_string;
                System.out.println("Entrez la latitude ( Attention utilisez une virgule )");
                lat = scanner.nextDouble();
                System.out.println("Entrez la longitude ( Attention utilisez une virgule )");
                lng = scanner.nextDouble();
                System.out.println("Entrez la date d'aujourd'hui ( format YYYY-MM-DD )");
                date_string = scanner.next();
                Date date = new SimpleDateFormat("YYYY-MM-DD").parse(date_string);
                //Timestamp ts = new Timestamp(date.getTime());
                System.out.println("A : " + ConnectionOpenWeather.getCity(lat,lng));
                System.out.println("La température est de : " + ConnectionOpenWeather.getTemperature(lat,lng) + " °C");
                Temperatures temp = new Temperatures(date,lat,lng);
                TemperaturesCRUD temperaturesCRUD = new TemperaturesCRUD();
                temperaturesCRUD.createTemperature(temp);
        }
        // Partie de Kevin
        System.out.println("----------------");
        System.out.println("Partie de Kevin");
        System.out.println("----------------");
        WorldCity worldCity1 = new WorldCity("Shanghai","Shanghai", BigDecimal.valueOf(31.1667), BigDecimal.valueOf(121.4667), "China", "CN", "CHN");
        WorldCityCRUD worldCityCRUD = new WorldCityCRUD();
        //.out.println(worldCityCRUD.findById(8));
        //System.out.println(worldCityCRUD.create(worldCity1));
        //System.out.println(worldCityCRUD.delete(7));
        //System.out.println(worldCityCRUD.update(worldCity1,3));

        System.out.println(ConnectionOpenWeather.getTemperature(31.1667,121.4667));
        System.out.println(ConnectionOpenWeather.getCity(31.1667,121.4667));




        // Partie de Shany
        System.out.println("----------------");
        System.out.println("Partie de Shany");
        System.out.println("----------------");



    }
}