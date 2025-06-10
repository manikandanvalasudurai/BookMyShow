package com.mani.example.bookmyshowjun25.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "seats")
public class Seat extends BaseModel{
    private String seatNumber;
    private int rowValue;
    private int colValue;
    @ManyToOne
    private SeatType seatType;
}

/*
    1        M
   Seat -> SeatType => M : M
    M         1
 */
