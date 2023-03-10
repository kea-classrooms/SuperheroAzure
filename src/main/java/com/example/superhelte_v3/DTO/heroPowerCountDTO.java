package com.example.superhelte_v3.DTO;

public class heroPowerCountDTO {

    String heroName;
    String realName;
    int amtOfPowers;

    public heroPowerCountDTO(String heroName, String realName, int amtOfPowers) {
        this.heroName = heroName;
        this.realName = realName;
        this.amtOfPowers = amtOfPowers;
    }

    public String getHeroName() {
        return heroName;
    }

    public String getRealName() {
        return realName;
    }

    public int getAmtOfPowers() {
        return amtOfPowers;
    }
}
