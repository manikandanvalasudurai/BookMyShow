package com.mani.example.bookmyshowjun25.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
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
}
/*
     1        1
    Show -> Movie => M : 1
     M        1

      1        1
     Show -> Screen => M : 1
      M        1
 */
