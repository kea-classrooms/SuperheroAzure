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


        // Tror ikke requestparam er nødvendig her ?
    @GetMapping(path = "/")
    public ResponseEntity<List<Superhero>> getSuperheroList(@RequestParam(required = false) String format){
        List<Superhero> list = superheroServices.getSuperheroRepository();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    /*
    Vi skal nu have mulighed for at anvende en request parameter, ‘format’,
    til ‘/’ endpointet, der angiver at vi ønsker output formateret til html.
    Brug af requestparameteren kommer til at se sådan ud: http://localhost:8080/superhelte?format=html

    I controller metoden formateres output fra vores service til en html tabel hvis
    requestparameteren eksisterer og er ‘html’. Ved brug af et StringBuilder objekt
    opbygges en html streng der indeholder html tags flettet sammen med data.

    Til slut returneres strengen i et ResponseEntity objekt sammen med en statuskode
     og en HTTPHeader der indeholder strengen “content-type:text/html”

    Da metoden skal være i stand til at returnere både en String (html) og en
    List<Superhelt> (superhelte objekter), angives metodens returværdi som
    ResponseEntity<?>
     */

    // Find superhero med pathvariable (stinavnet)
    @GetMapping(path = "/{name}")
    public ResponseEntity<Superhero> getSuperhero(@PathVariable String name){
        Superhero s = superheroServices.getSuperheroByName(name);
        return new ResponseEntity<>(s, HttpStatus.OK);
    }

    // find superhero med RequestParam (?name=xxx osv)
    @GetMapping("/name")
    public ResponseEntity<Superhero> getSuperheroByParam(@RequestParam String name){
        Superhero s = superheroServices.getSuperheroByName(name);
        return new ResponseEntity<>(s, HttpStatus.OK);
    }

    // Requestparam bruger ?name=nlalal&supeheropower=blblbl
    @GetMapping("/opret")
    public ResponseEntity<Superhero> opretHero(@RequestParam String superheroName, @RequestParam String superheroPower, @RequestParam int creationYear){
            Superhero s = new Superhero(superheroName, "realnametest", superheroPower, creationYear, "testby");
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
        return new ResponseEntity<>(name + "has been deleted", HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<Superhero> editSuperHero(@RequestBody Superhero s) {
            superheroServices.replaceSuperhero(s);
            return new ResponseEntity<>(s, HttpStatus.OK);
    }


    // Opgave 1-4 Superhelte v.4

    // opg1 - returner heroName, realName og creationYear
    @GetMapping(path = "/opgave1")
    public ResponseEntity<List<Superhero>> opgave1(@RequestParam(required = false) String format){
        List<Superhero> list = superheroServices.getSuperheroRepository();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }



}
