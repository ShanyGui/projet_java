package org.example.connection;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

import org.json.JSONObject;

public class ConnectionOpenWeather {

    public static float getTemperature(double lat,double lon){ // Pensez à convertir lors de l'appel de la méthode avec les données de l'API.
        float temp = 0;
        try {
            // On créé le client
            var client = HttpClient.newHttpClient();
            // On créé la requête
            var request = HttpRequest.newBuilder(URI.create("https://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon + "&appid=3e245e4b32fb92ee3772fa220c013d77&lang=fr&units=metric"))
                    //.header("accept", "application/json") // semble inutile ici
                    .build();
            //var response = client.send(request, new JsonBodyHandler<>(APOD.class));
            JSONObject result = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenApply(HttpResponse::body)
                    .thenApply(JSONObject::new)
                    .join();
            temp = result.getJSONObject("main").getFloat("temp");
        }
        catch (RuntimeException e) {
            e.printStackTrace();
        }
        return temp;
    }

    public static String getCity(double lat,double lon) { // Pemet de récupérer le nom de la ville correspondant aux coordonnées
        // On créé le client
        var client = HttpClient.newHttpClient();

        // On créé la requête
        var request = HttpRequest.newBuilder(URI.create("https://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon + "&appid=3e245e4b32fb92ee3772fa220c013d77&lang=fr"))
                //.header("accept", "application/json") // semble inutile ici
                .build();


        //var response = client.send(request, new JsonBodyHandler<>(APOD.class));
        JSONObject result = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(JSONObject::new)
                .join();

        String city = result.getString("name");

        return city;
    }

    public static ArrayList getCoordonatesByCity(String city) { // Pemet de récupérer les coordonées d'une ville via son nom
        // On créé le client
        var client = HttpClient.newHttpClient();
        // On créé la requête
        var request = HttpRequest.newBuilder(URI.create("https://api.openweathermap.org/data/2.5/weather?q="+ city +"&appid=3e245e4b32fb92ee3772fa220c013d77&lang=fr"))
                .build();
        //var response = client.send(request, new JsonBodyHandler<>(APOD.class));
        JSONObject result = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(JSONObject::new)
                .join();

        float lat = result.getJSONObject("coord").getFloat("lat");
        float lon = result.getJSONObject("coord").getFloat("lon");
        ArrayList coord = new ArrayList<>();
        coord.add(lat);
        coord.add(lon);
        return coord;
    }



}

