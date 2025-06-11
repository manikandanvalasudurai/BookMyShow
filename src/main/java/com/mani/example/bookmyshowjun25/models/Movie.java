package com.mani.example.bookmyshowjun25.models;

import jakarta.persistence.Entity;

@Entity(name = "movies")
public class Movie extends BaseModel {
    private String movie;
    private double rating;

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
