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
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Scanner.*;

public class Main {
    public static void main(String[] args) throws ParseException {
        System.out.println("Initialisation");
        System.out.println("Veuillez choisir l'opération à réaliser : \n 1- Connaître la température d'un point du globe " +
                "\n 2- Lire et enregistrer la température d'un point du globe");
        Scanner scanner = new Scanner(System.in);
        int choix = scanner.nextInt();
        double lat;
        double lng;
        switch(choix){
            case 1:
                System.out.println("Entrez la latitude ( Attention utilisez une virgule )");
                lat = scanner.nextDouble();
                System.out.println("Entrez la longitude ( Attention utilisez une virgule )");
                lng = scanner.nextDouble();
                System.out.println("A : " + ConnectionOpenWeather.getCity(lat,lng));
                System.out.println("La température est de : " + ConnectionOpenWeather.getTemperature(lat,lng) + " °C");
            case 2:
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
            case 3:
                WorldCityCRUD wccrud = new WorldCityCRUD();
                WorldCity city;
                System.out.println("Entrez le nom de la ville que vous cherchez :");
                String search = scanner.next();
                city = wccrud.findByCity(search);
                if (city != null){
                    System.out.println("La latitude de " + search + " est : "+ city.getLat());
                    System.out.println("La longitude de " + search + " est : "+ city.getLng());
                } else {
                    System.out.println("Nous ne possédons aucune information sur cette ville.");
                }
            case 4:
                WorldCityCRUD findcity = new WorldCityCRUD();
                WorldCity cityfound;
                ArrayList coords = new ArrayList<>();
                System.out.println("Entrez le nom de la ville que vous cherchez :");
                String searchCity = scanner.next();
                coords = ConnectionOpenWeather.getCoordonatesByCity(searchCity);
                if (coords != null){
                    System.out.println("La latitude et la longitude de votre recherche sont : 4");
                    for (Object coord : coords){
                        System.out.println(coord);
                    }
                }else{
                    System.out.println("Aucun résultat trouvé");
                }
        }
    }
}