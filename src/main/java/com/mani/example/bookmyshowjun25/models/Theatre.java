package com.mani.example.bookmyshowjun25.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "theatres")
public class Theatre extends BaseModel{
    private String name;
    private String Address;
    @OneToMany
    @JoinColumn(name = "theatreId")
    private List<Screen> screens;
    @OneToMany
    @JoinColumn(name = "theatreId")
    private List<City> cities;
}
/*
   1         M
Theatre -> Screen => 1:M
    1         1
 */