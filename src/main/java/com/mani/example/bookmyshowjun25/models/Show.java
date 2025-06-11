package com.mani.example.bookmyshowjun25.models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity(name = "shows")
public class Show extends BaseModel{
    @ManyToOne
    private Movie movie;
    private Date startTime;
    private Date endTime;
    @ManyToOne
    private Screen screen;
    @ElementCollection // @ElementCollection tells JPA: "I'm storing a collection of simple values (not entities)."
    @Enumerated(EnumType.ORDINAL) // @Enumerated(EnumType.STRING) tells JPA: "Store the enum as a string in the DB column."
    private List<Feature> features;

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }
}
/*
     1        1
    Show -> Movie => M : 1
     M        1

      1        1
     Show -> Screen => M : 1
      M        1
 */
