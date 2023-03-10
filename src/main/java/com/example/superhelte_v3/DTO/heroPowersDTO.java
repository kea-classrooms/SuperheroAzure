package com.example.superhelte_v3.DTO;

import java.util.ArrayList;

public class heroPowersDTO {

    String heroName, realName;
    ArrayList<String> listOfPowers;

    public heroPowersDTO(String heroName, String realName, ArrayList<String> listOfPowers) {
        this.heroName = heroName;
        this.realName = realName;
        this.listOfPowers = listOfPowers;
    }

    public String getHeroName() {
        return heroName;
    }

    public String getRealName() {
        return realName;
    }

    public ArrayList<String> getListOfPowers() {
        return listOfPowers;
    }
}
