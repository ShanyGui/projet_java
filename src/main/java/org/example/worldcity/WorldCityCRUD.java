package org.example.worldcity;

import org.example.connection.MySqlConnector;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

public class WorldCityCRUD {

    public WorldCity create(WorldCity worldCity) {

        Connection con = MySqlConnector.getConnection();
        String createRequest = "INSERT INTO WorldCities ( city , city_ascii , lat , lng , country , iso2 , iso3) " +
                "VALUES (? , ? , ? , ? , ? , ? , ?);";

        try {
            PreparedStatement ps = con.prepareStatement(createRequest, PreparedStatement.RETURN_GENERATED_KEYS);
            // les cles ne sont necessaires que pour les insertions
            ps.setString(1, worldCity.getCity());
            ps.setString(2, worldCity.getCity_ascii());
            ps.setBigDecimal(3, worldCity.getLat());
            ps.setBigDecimal(4, worldCity.getLng());
            ps.setString(5, worldCity.getCountry());
            ps.setString(6, worldCity.getIso2());
            ps.setString(7, worldCity.getIso3());

            ps.execute();
            ResultSet keys = ps.getGeneratedKeys();
            if (keys.next()) {
                System.out.println("Insertion réussie avec une clé primaire : " + keys.getInt(1));
            } else {
                System.out.println("Problème d'insertion");
            }


        } catch (SQLException e) {
            e.printStackTrace();


        }
        return worldCity;
    }

    public ArrayList<WorldCity> readAll() {

        ArrayList<WorldCity> worldCities = null;
        Connection con = MySqlConnector.getConnection();
        String selectRequest = "SELECT * FROM worldCities";

        try {
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(selectRequest);
            worldCities = new ArrayList<>();
            while (result.next()) {
                int id = result.getInt("id");
                String city = result.getString(2);
                String city_ascii = result.getString("city_ascii");
                BigDecimal lat = result.getBigDecimal("lat");
                BigDecimal lng = result.getBigDecimal("lng");
                String country = result.getString("country");
                String iso2 = result.getString("iso2");
                String iso3 = result.getString("iso3");
                WorldCity worldCity = new WorldCity(id,city,city_ascii,lat,lng,country,iso2,iso3);
                worldCities.add(worldCity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return worldCities;
    }

    public WorldCity findById(int id) {
        Connection con = MySqlConnector.getConnection();
        String findByIdRequest = "SELECT * FROM worldcities WHERE id = ?";
        try{
            PreparedStatement ps = con.prepareStatement(findByIdRequest);
            ps.setInt(1, id);

            ps.executeQuery();

            ResultSet result = ps.executeQuery();
            if(result.next()){
                String city = result.getString(2);
                String city_ascii = result.getString("city_ascii");
                BigDecimal lat = result.getBigDecimal("lat");
                BigDecimal lng = result.getBigDecimal("lng");
                String country = result.getString("country");
                String iso2 = result.getString("iso2");
                String iso3 = result.getString("iso3");
                return new WorldCity(id,city,city_ascii,lat,lng,country,iso2,iso3);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public WorldCity findByCity(String namecity) {
        Connection con = MySqlConnector.getConnection();
        String findByIdRequest = "SELECT * FROM worldcities WHERE city = ?";
        try{
            PreparedStatement ps = con.prepareStatement(findByIdRequest);
            ps.setString(1, namecity);
            ps.executeQuery();
            ResultSet result = ps.executeQuery();
            if(result.next()){
                String city = result.getString(2);
                String city_ascii = result.getString("city_ascii");
                BigDecimal lat = result.getBigDecimal("lat");
                BigDecimal lng = result.getBigDecimal("lng");
                String country = result.getString("country");
                String iso2 = result.getString("iso2");
                String iso3 = result.getString("iso3");
                return new WorldCity(city,city_ascii,lat,lng,country,iso2,iso3);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public WorldCity update(WorldCity worldCity, int id) {

        Connection con = MySqlConnector.getConnection();
        String updateRequest = "UPDATE worldcities SET city = ?, city_ascii = ?, lat = ?, lng = ?, country = ?, iso2 = ?, iso3 = ? WHERE id = ? ";
        try{
            PreparedStatement ps = con.prepareStatement(updateRequest);
            ps.setString(1, worldCity.getCity());
            ps.setString(2, worldCity.getCity_ascii());
            ps.setBigDecimal(3, worldCity.getLat());
            ps.setBigDecimal(4, worldCity.getLng());
            ps.setString(5, worldCity.getCountry());
            ps.setString(6, worldCity.getIso2());
            ps.setString(7, worldCity.getIso3());

            ps.setInt(8, id);

            return ps.executeUpdate() > 0 ? worldCity : null; // si c vrai alors retourne personne sinon null




        } catch (SQLException e) {
            e.printStackTrace();


        }
        return worldCity;
    }

    public boolean delete(int id) {

        Connection con = MySqlConnector.getConnection();
        String deleteRequest = "DELETE FROM worldcities WHERE id = ? ";
        try{
            PreparedStatement ps = con.prepareStatement(deleteRequest);
            ps.setInt(1, id);

            return ps.executeUpdate() > 0 ? true : false;



        } catch (SQLException e) {
            e.printStackTrace();


        }
        return false;
    }

}
