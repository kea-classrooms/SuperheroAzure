package com.example.superhelte_v3.repositories;

import com.example.superhelte_v3.model.Superhero;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SuperheroRepository {

    private ArrayList<Superhero> superheroDatabase = new ArrayList<>(List.of(
            new Superhero("Superhero1", "realname1", 1990),
            new Superhero("Superhero2", "realname2", 1994),
            new Superhero("Superhero3", "realname3", 1992)
    ));

    public void addSuperheroToDatabase(Superhero s) {
        superheroDatabase.add(s);
    }

    public void replaceSuperhero(Superhero s){
        for (Superhero superhero : superheroDatabase) {
            if (s.getSuperheroName().equals(superhero.getSuperheroName()))
                superheroDatabase.remove(superhero);
                superheroDatabase.add(s);
        }
    }

    public Superhero getSuperhero(String name){
        Superhero superhero = null;
        for (Superhero s : superheroDatabase) {
            if (s.getSuperheroName().equalsIgnoreCase(name)) {
                superhero = s;
            }
        }
        return superhero;
    }

    public ArrayList<Superhero> getSuperHeroDatabase() {
        return superheroDatabase;
    }

    public void deleteHero(String name) {
        for (Superhero s : superheroDatabase) {
            if (s.getSuperheroName().equalsIgnoreCase(name)) {
                superheroDatabase.remove(s);
            }
        }
    }


}
