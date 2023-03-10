package com.example.superhelte_v3.model;

public class Superhero {
    private String superheroName;
    private String realName;
    private int creationYear;

    public Superhero(String superheroName, String realName, int creationYear) {
        this.superheroName = superheroName;
        this.realName = realName;
        this.creationYear = creationYear;
    }

    public String getSuperheroName() {
        return superheroName;
    }

    public void setSuperheroName(String superheroName) {
        this.superheroName = superheroName;
    }

    public String getRealName() {
        return realName;
    }

    /*
    public String getCity() {
        return city;
    } */


    public int getCreationYear() {
        return creationYear;
    }

    public void setCreationYear(int creationYear) {
        this.creationYear = creationYear;
    }



    public String PrintSuperHeroName() {
        String s;
        if (superheroName == null) {
            return "* Har ikke superheltenavn *";
        } else {
            return superheroName;
        }
    }


}
