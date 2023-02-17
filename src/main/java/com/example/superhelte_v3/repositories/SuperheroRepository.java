package com.example.superhelte_v3.repositories;

import com.example.superhelte_v3.model.Superhero;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SuperheroRepository {


    private ArrayList<Superhero> superheroDatabase = new ArrayList<>(List.of(
            new Superhero("Superhero1", "fly", 1990),
            new Superhero("Superhero2", "fly", 1994),
            new Superhero("Superhero3", "fly", 1992)

    ));
    private ArrayList<Superhero> findSuperheroList = new ArrayList<>();

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

    public void setSuperHeroDatabase(ArrayList<Superhero> superheroDatabase) {
        this.superheroDatabase = superheroDatabase;
    }

    public ArrayList<Superhero> getFindSuperheroList() {
        return findSuperheroList;
    }

    public void addToDatabase(String name, String superheroName, String superheroPower, int creationYear) {
        superheroDatabase.add(new Superhero(superheroName, superheroPower,creationYear));
    }

    public void deleteHero(String name) {
        for (Superhero s : superheroDatabase) {
            if (s.getSuperheroName().equalsIgnoreCase(name)) {
                superheroDatabase.remove(s);
            }
        }
    }


    //Samler en gruppe af helte, når man skal gemme resultater. Bruges til når der skal redigeres.
    public ArrayList<Superhero> searchForHeroList(String searchName) {
        Superhero hero;
        findSuperheroList.clear(); //Clear for at når man søger flere gange så gemmes de gamle svar ikke

        for (int n = 0; n < superheroDatabase.size(); n++) {
            hero = superheroDatabase.get(n);
            if (hero.getSuperheroName() != null && hero.getSuperheroName().contains(searchName.toLowerCase())) {
                findSuperheroList.add(hero);
            }
        }
        return findSuperheroList;
    }

}
