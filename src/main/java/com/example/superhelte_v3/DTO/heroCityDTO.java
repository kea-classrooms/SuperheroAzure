package com.example.superhelte_v3.DTO;

public class heroCityDTO {

    String heroName, cityName;

    public heroCityDTO(String heroName, String cityName) {
        this.heroName = heroName;
        this.cityName = cityName;
    }

    public String getHeroName() {
        return heroName;
    }

    public String getCityName() {
        return cityName;
    }
}
