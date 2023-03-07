package com.example.superhelte_v3.repositories;

import com.example.superhelte_v3.model.Superhero;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SuperheroRepository_DB {

    @Repository
    public class SuperheroRepository {

        @Value("${spring.datasource.url}")
        private String db_url;

        @Value("${spring.datasource.username}")
        private String uid;

        @Value("${spring.datasource.password}")
        private String pwd;


        // her skal der bruges try with resources fra side 8 JDBC og Spring Boot

        public ArrayList<Superhero> getSuperheroesFromDB() {
            ArrayList<Superhero> list = new ArrayList<Superhero>();
            try (Connection con = DriverManager.getConnection(db_url, uid, pwd)) {
                String SQL = "SELECT * FROM superheroes";
                Statement stnt = con.createStatement();
                ResultSet rs = stnt.executeQuery(SQL);

                while (rs.next()) {
                    String heroName = rs.getString("heroName");
                    String realName = rs.getString("heroName");
                    int creationYear = rs.getInt("creationYear");
                    
                }
            } catch (SQLException e) {
                throw new RuntimeException();
            }
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
}
