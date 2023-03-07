package com.example.superhelte_v3.model;

public class Superhero {

    private String superheroName;
    private String realName;
    private String superheroPower;
    private int creationYear;
    //private String city;

    public Superhero(String superheroName, String realName, String superheroPower, int creationYear, String city) {
        this.superheroName = superheroName;
        this.realName = realName;
        this.superheroPower = superheroPower;
        this.creationYear = creationYear;
        //this.city = city;
    }

    public String getSuperheroName() {
        return superheroName;
    }

    public void setSuperheroName(String superheroName) {
        this.superheroName = superheroName;
    }

    public String getSuperheroPower() {
        return superheroPower;
    }

    public String getRealName() {
        return realName;
    }

    /*
    public String getCity() {
        return city;
    } */

    public void setSuperheroPower(String superheroPower) {
        this.superheroPower = superheroPower;
    }

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


    @Override
    public String toString() {
        return String.format("┃ %-20s │ %-15s │ %-20s │ %-8b │ %-13d ┃", superheroName, superheroPower, creationYear);
    }

}
