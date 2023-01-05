package org.example;

import org.example.worldcity.WorldCity;
import org.example.worldcity.WorldCityCRUD;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        System.out.println("Initialisation");
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




        // Partie de Shany
        System.out.println("----------------");
        System.out.println("Partie de Shany");
        System.out.println("----------------");



    }
}