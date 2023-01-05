package org.example.connection;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.JSONObject;

public class ConnectionOpenWeather {

    public static float getTemperature(double lat, double lon){
        float temp = 0;

        try{
            // On créé le client
            var client = HttpClient.newHttpClient();
            // On build la requête
            var request = HttpRequest.newBuilder(URI.create("https://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon + "&appid=3e245e4b32fb92ee3772fa220c013d77"))
                    .build();
            //var response = client.send(request, new JsonBodyHandler<>(APOD.class));
            JSONObject result = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenApply(HttpResponse::body)
                    .thenApply(JSONObject::new)
                    .join(); // prise de la pause

            JSONObject main = result.getJSONObject("main");
            temp = main.getFloat("temp");

        }catch (RuntimeException e){
           e.printStackTrace();
        }

        return temp;
    }



}