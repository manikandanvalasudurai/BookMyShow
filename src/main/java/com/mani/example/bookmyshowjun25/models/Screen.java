package com.mani.example.bookmyshowjun25.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "screens")
public class Screen extends BaseModel{
    private String name;
    @OneToMany
    private List<Seat> seats;
    @ElementCollection
    @Enumerated(EnumType.ORDINAL)
    private List<Feature> features;
}

/*
       1        M
    Screen --> Seat => 1 : M
        1       1
 */
