package com.mani.example.bookmyshowjun25.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity(name = "screens")
public class Screen extends BaseModel{
    private String name;
    @OneToMany
    private List<Seat> seats;
    @ElementCollection
    @Enumerated(EnumType.ORDINAL)
    private List<Feature> features;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }
}

/*
       1        M
    Screen --> Seat => 1 : M
        1       1
 */
