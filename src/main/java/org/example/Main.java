package org.example;

import org.example.connection.ConnectionOpenWeather;
import org.example.worldcity.WorldCity;
import org.example.worldcity.WorldCityCRUD;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Scanner.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Initialisation");
        System.out.println("Veuillez choisir l'opération à réaliser :   \n 1 - Connaître la température d'un point du globe " +
                                                                        "\n 3 - Trouver les coordonées GPS d'une ville donnée" +
                                                                        "\n 4 - Trouver les coordonées GPS d'une ville donnée via OpenWeather");

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
                System.out.println("La température est de : " + ConnectionOpenWeather.getTemperature(lat,lng) + " K");
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

/*        // Partie de Kevin
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
        System.out.println(ConnectionOpenWeather.getCity(31.1667,121.4667));*/


        // Partie de Shany
/*        System.out.println("----------------");
        System.out.println("Partie de Shany");
        System.out.println("----------------");*/



    }
}