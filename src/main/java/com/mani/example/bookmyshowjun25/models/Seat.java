package com.mani.example.bookmyshowjun25.models;

import jakarta.persistence.*;

@Entity(name = "seats")
public class Seat extends BaseModel{
    private String seatNumber;
    private int rowValue;
    private int colValue;
    @ManyToOne
    private SeatType seatType;

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public int getRowValue() {
        return rowValue;
    }

    public void setRowValue(int rowValue) {
        this.rowValue = rowValue;
    }

    public int getColValue() {
        return colValue;
    }

    public void setColValue(int colValue) {
        this.colValue = colValue;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }
}

/*
    1        M
   Seat -> SeatType => M : M
    M         1
 */
