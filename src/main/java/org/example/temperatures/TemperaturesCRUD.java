package org.example.temperatures;

import org.example.connection.MySqlConnector;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TemperaturesCRUD {
    public void createTemperature(Temperatures temperature) {
        try{
            Connection con = MySqlConnector.getConnection();
            Statement statement = con.createStatement();
            String sqlquery = "INSERT INTO temperatures (timestamp, city, temperature) VALUES (? , ? , ?); ";
            PreparedStatement preparedStatement = con.prepareStatement(sqlquery, PreparedStatement.RETURN_GENERATED_KEYS);;
            preparedStatement.setDate(1, new java.sql.Date(temperature.getTimestamp().getTime()));
            preparedStatement.setString(2, temperature.getCity());
            preparedStatement.setBigDecimal(3, temperature.getTemperature());

            preparedStatement.executeUpdate();
            ResultSet keys = preparedStatement.getGeneratedKeys();
            if (keys.next()) {
                System.out.println("Insertion réussie avec une clé primaire : " + keys.getInt(1));
            } else {
                System.out.println("Problème d'insertion");
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<Temperatures> readAllTemperatures() {
        List<Temperatures> temperatures = new ArrayList<>();
        try{
            Connection con = MySqlConnector.getConnection();
            String sqlquery = "SELECT * FROM temperatures";
            PreparedStatement preparedStatement = con.prepareStatement(sqlquery);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
//                System.out.println(rs.getInt(1) + rs.getString(2) + rs.getString(3));
                Temperatures temperature = new Temperatures(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getBigDecimal(4));
                temperatures.add(temperature);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return temperatures;
    }

    public Temperatures readTemperatures(int id) {
        try{
            Connection con = MySqlConnector.getConnection();
            String sqlquery = "SELECT * FROM temperatures WHERE id = ?";
            PreparedStatement preparedStatement = con.prepareStatement(sqlquery);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
//                System.out.println(rs.getInt(1) + rs.getString(2) + rs.getString(3));
                Temperatures temperature = new Temperatures(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getBigDecimal(4));
                return temperature;
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return null;
    }

    public void updateTemperature(Temperatures temperatures, int id) {
        try{
            Connection con = MySqlConnector.getConnection();
            String sqlquery = "UPDATE temperatures SET timestamp = ?, city = ?, temperature = ?  WHERE id = ?";
            PreparedStatement preparedStatement = con.prepareStatement(sqlquery);
            preparedStatement.setDate(1, (Date) temperatures.getTimestamp());
            preparedStatement.setString(2, temperatures.getCity());
            preparedStatement.setBigDecimal(3, temperatures.getTemperature());

            int execUp = preparedStatement.executeUpdate();
            if (execUp > 0){
                System.out.println("Update réussi");
            }else{
                System.out.println("ECHEC CUISANT ZEUBI");
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void deleteTemperature(int id) {
        try{
            Connection con = MySqlConnector.getConnection();
            String sqlquery = "DELETE FROM temperatures WHERE id = ?";
            PreparedStatement preparedStatement = con.prepareStatement(sqlquery);
            preparedStatement.setInt(1, id);

            int execUp = preparedStatement.executeUpdate();
            if (execUp > 0){
                System.out.println("Suppression réussie");
            }else{
                System.out.println("ECHEC CUISANT ZEUBI");
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }



}
