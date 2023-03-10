package com.example.superhelte_v3.controllers;

import com.example.superhelte_v3.DTO.heroCityDTO;
import com.example.superhelte_v3.DTO.heroPowerCountDTO;
import com.example.superhelte_v3.DTO.heroPowersDTO;
import com.example.superhelte_v3.model.Superhero;
import com.example.superhelte_v3.repositories.SuperheroRepository_DB;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "superhero")

    public class SuperheroController {
        private SuperheroRepository_DB db = new SuperheroRepository_DB();


    @GetMapping(path = "/")
    public ResponseEntity<List<Superhero>> getSuperheroList(@RequestParam(required = false) String format){
        ArrayList<Superhero> list = db.getSuperheroesFromDB();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(path = "/{name}")
    public ResponseEntity<Superhero> getSuperhero(@PathVariable String name){
        ArrayList<Superhero> list = db.getSuperheroesFromDB();
        Superhero hero = null;
        for (Superhero s : list) {
            if (s.getSuperheroName().equalsIgnoreCase(name)) {
                hero = s;
            }
        }
        return new ResponseEntity<>(hero, HttpStatus.OK);
    }

    @GetMapping(path = "/{name}/powercount")
    public ResponseEntity<heroPowerCountDTO> getHeroPowerCount(@PathVariable String name){
        ArrayList<heroPowerCountDTO> list = db.getHeroPowerCount();
        heroPowerCountDTO ob = null;
        for (heroPowerCountDTO a : list) {
            if (a.getHeroName().equalsIgnoreCase(name)) {
                ob = a;
            }
        }
        return new ResponseEntity<>(ob, HttpStatus.OK);
    }

    @GetMapping(path = "/{name}/powers")
    public ResponseEntity<heroPowersDTO> getHeroPowers(@PathVariable String name){
        ArrayList<heroPowersDTO> list = db.getHeroPowers(name);
        heroPowersDTO ob = null;
        for (heroPowersDTO a : list) {
            if (a.getHeroName().equalsIgnoreCase(name)) {
                ob = a;
            }
        }
        return new ResponseEntity<>(ob, HttpStatus.OK);
    }

    @GetMapping(path = "/{name}/city")
    public ResponseEntity<heroCityDTO> getHeroCity(@PathVariable String name){
        ArrayList<heroCityDTO> list = db.getHeroCity(name);
        heroCityDTO ob = null;
        for (heroCityDTO a : list) {
            if (a.getHeroName().equalsIgnoreCase(name)) {
                ob = a;
            }
        }
        return new ResponseEntity<>(ob, HttpStatus.OK);
    }


        /*
    @GetMapping(path = "/")
    public ResponseEntity<List<Superhero>> getSuperheroList(@RequestParam(required = false) String format){
        List<Superhero> list = superheroServices.getSuperheroRepository();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    // Find superhero med pathvariable (stinavnet)
    @GetMapping(path = "/{name}")
    public ResponseEntity<Superhero> getSuperhero(@PathVariable String name){
        Superhero s = superheroServices.getSuperheroByName(name);
        return new ResponseEntity<>(s, HttpStatus.OK);
    } */




}
