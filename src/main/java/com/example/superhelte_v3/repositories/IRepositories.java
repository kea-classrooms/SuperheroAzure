package com.example.superhelte_v3.repositories;

import com.example.superhelte_v3.DTO.heroCityDTO;
import com.example.superhelte_v3.DTO.heroPowerCountDTO;
import com.example.superhelte_v3.DTO.heroPowersDTO;
import com.example.superhelte_v3.model.Superhero;

import java.util.ArrayList;

public interface IRepositories {

    public ArrayList<Superhero> getSuperheroesFromDB();
    public ArrayList<heroPowerCountDTO> getHeroPowerCount();
    public ArrayList<heroPowersDTO> getHeroPowers(String name);
    public ArrayList<heroCityDTO> getHeroCity(String name);

}
