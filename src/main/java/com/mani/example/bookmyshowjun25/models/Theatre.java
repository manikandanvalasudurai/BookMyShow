package com.mani.example.bookmyshowjun25.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

import java.util.List;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public List<Screen> getScreens() {
        return screens;
    }

    public void setScreens(List<Screen> screens) {
        this.screens = screens;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }
}
/*
   1         M
Theatre -> Screen => 1:M
    1         1
 */