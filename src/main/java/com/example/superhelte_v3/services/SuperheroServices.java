package com.example.superhelte_v3.services;

import com.example.superhelte_v3.model.Superhero;
import com.example.superhelte_v3.repositories.SuperheroRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SuperheroServices {

    private SuperheroRepository superheroRepository;

    public SuperheroServices(SuperheroRepository superheroRepository) {
        this.superheroRepository = new SuperheroRepository();
    }

    public ArrayList<Superhero> getSuperheroRepository() {
        return superheroRepository.getSuperHeroDatabase();
    }

    // Returnere superhero ved navn
    public Superhero getSuperheroByName(String name) {
        return superheroRepository.getSuperhero(name);
    }

    public void addSuperheroToDatabase(Superhero s) {
        superheroRepository.addSuperheroToDatabase(s);
    }

    public void deleteSuperheroFromDatabase(String name) {
        superheroRepository.deleteHero(name);
    }

    public void replaceSuperhero(Superhero s) {
        superheroRepository.replaceSuperhero(s);
    }


}
