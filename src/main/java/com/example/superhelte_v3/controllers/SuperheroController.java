package com.example.superhelte_v3.controllers;

import com.example.superhelte_v3.model.Superhero;
import com.example.superhelte_v3.services.SuperheroServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "superhero")
    public class SuperheroController {

        private SuperheroServices superheroServices;

        public SuperheroController(SuperheroServices superheroServices) {
            this.superheroServices = superheroServices;
        }


    @GetMapping(path = "/")
    public ResponseEntity<List<Superhero>> getSuperheroList(@RequestParam(required = false) String format){
        List<Superhero> list = superheroServices.getSuperheroRepository();
        return new ResponseEntity<List<Superhero>>(list, HttpStatus.OK);
    }

    // bruger bare stinavnet
    @GetMapping(path = "/{name}")
    public ResponseEntity<Superhero> getSuperhero(@PathVariable String name){
        Superhero s = superheroServices.getSuperheroByName(name);
        return new ResponseEntity<>(s, HttpStatus.OK);
    }

    // Requestparam bruger ?name=nlalal&supeheropoer=blblbl
    @GetMapping("/opret")
    public ResponseEntity<Superhero> opretHero(@RequestParam String superheroName, @RequestParam String superheroPower, @RequestParam int creationYear){
            Superhero s = new Superhero(superheroName, superheroPower, creationYear);
            superheroServices.addSuperheroToDatabase(s);
            return new ResponseEntity<>(s, HttpStatus.OK);
    }

    @PostMapping("/opretByPost")
    public ResponseEntity<Superhero> opretHeroByPost(@RequestBody Superhero s){
            superheroServices.addSuperheroToDatabase(s);
            return new ResponseEntity<>(s, HttpStatus.OK);
    }


    // Delete med requestparam
    @GetMapping("/delete")
    public ResponseEntity<String> deleteHero(@RequestParam String name) {
            superheroServices.deleteSuperheroFromDatabase(name);
            return new ResponseEntity<>(name + "has been deleted", HttpStatus.OK);
    }

    @GetMapping("/delete/{name}")
    public ResponseEntity<String> deleteHeroByPath(@PathVariable String name) {
        superheroServices.deleteSuperheroFromDatabase(name);
        return new ResponseEntity<>(name, HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<Superhero> editSuperHero(@RequestBody Superhero s) {
            superheroServices.replaceSuperhero(s);
            return new ResponseEntity<>(s, HttpStatus.OK);
    }

}
