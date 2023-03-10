package com.example.superhelte_v3.repositories;

import com.example.superhelte_v3.DTO.heroCityDTO;
import com.example.superhelte_v3.DTO.heroPowerCountDTO;
import com.example.superhelte_v3.DTO.heroPowersDTO;
import com.example.superhelte_v3.model.Superhero;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SuperheroRepository_DB {
    @Value("${spring.datasource.url}")
    private String db_url;

    @Value("${spring.datasource.username}")
    private String uid;

    @Value("${spring.datasource.password}")
    private String pwd;

    public ArrayList<Superhero> getSuperheroesFromDB() {
        ArrayList<Superhero> list = new ArrayList<Superhero>();
        try (Connection con = DriverManager.getConnection(db_url, uid, pwd)) {
            String SQL = "SELECT * FROM superhero";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                String heroName = rs.getString("heroName");
                String realName = rs.getString("realName");
                int creationYear = rs.getInt("creationYear");
                list.add(new Superhero(heroName, realName, creationYear));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // throw new RuntimeException();
        } return list;
    }

    public ArrayList<heroPowerCountDTO> getHeroPowerCount() {
        ArrayList<heroPowerCountDTO> list = new ArrayList<heroPowerCountDTO>();
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/superheroes", "root", "nico1919")) {
            String SQL = "select heroName, realName, (select count(*) from superherosuperpower where superhero_id = id) as powerCount from superhero;";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                String heroName = rs.getString("heroName");
                String realName = rs.getString("realName");
                int powerCount = rs.getInt("powerCount");
                list.add(new heroPowerCountDTO(heroName, realName, powerCount));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // throw new RuntimeException();
        } return list;
    }

    public ArrayList<heroPowersDTO> getHeroPowers(String name) {
        ArrayList<heroPowersDTO> list = new ArrayList<heroPowersDTO>();
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/superheroes", "root", "nico1919")) {
            String SQL = "select heroName, realName, name from superhero, superpower, superherosuperpower"
                    + " where superpower.id = superherosuperpower.superpower_id"
                    + " and superhero.id = superherosuperpower.superhero_id"
                    + " and heroName = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            ArrayList<String> powers = new ArrayList<String>();
            while (rs.next()) {
                String heroName = rs.getString(1);
                String realName = rs.getString(2);
                powers.add(rs.getString(3));
                list.add(new heroPowersDTO(heroName, realName, powers));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // throw new RuntimeException();
        } return list;
    }

    public ArrayList<heroCityDTO> getHeroCity(String name) {
        ArrayList<heroCityDTO> list = new ArrayList<heroCityDTO>();
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/superheroes", "root", "nico1919")) {
            String SQL = "select heroName, name from superhero, city"
                    + " where superhero.city_id = city.id"
                    + " and heroName = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String heroName = rs.getString(1);
                String cityName = rs.getString(2);
                list.add(new heroCityDTO(heroName, cityName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // throw new RuntimeException();
        } return list;
    }


    /*
    public void addSuperheroToDatabase(Superhero s) {
    }

    public void replaceSuperhero(Superhero s){
    }

    public Superhero getSuperhero(String name){
    }

    public ArrayList<Superhero> getSuperHeroDatabase() {
    }

    public void deleteHero(String name) {
    }
     */



}

