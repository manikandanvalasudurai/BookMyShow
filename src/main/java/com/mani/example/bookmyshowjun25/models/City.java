package com.mani.example.bookmyshowjun25.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;


import java.util.List;

@Entity(name ="cities")
public class City extends BaseModel{
    private String name;
    @OneToMany
    @JoinColumn(name = "cityId")
    private List<Theatre> theatres;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Theatre> getTheatres() {
        return theatres;
    }

    public void setTheatres(List<Theatre> theatres) {
        this.theatres = theatres;
    }
}

/*
  1       M
City -> Theatre => 1:M
  M         1
 */
