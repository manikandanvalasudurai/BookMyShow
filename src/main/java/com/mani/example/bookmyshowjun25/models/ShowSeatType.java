package com.mani.example.bookmyshowjun25.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeatType extends BaseModel {
    //A basic mapping class -> price of particular show Along with particular SeatType
    @ManyToOne
    private Show show;
    @OneToOne
    private SeatType seatType;
    private int price;

}

/*
        1            1
    ShowSeatType -> Show => M : 1
        M             1

       1             1
    ShowSeatType -> SeatType => 1 : 1
       M             1

 */