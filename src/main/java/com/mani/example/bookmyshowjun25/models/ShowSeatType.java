package com.mani.example.bookmyshowjun25.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeatType extends BaseModel {
    //A basic mapping class -> price of particular show Along with particular SeatType
    private Show show;
    private SeatType seatType;
    private int price;

}
