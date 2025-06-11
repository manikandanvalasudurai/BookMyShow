package com.mani.example.bookmyshowjun25.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
public class ShowSeatType extends BaseModel {
    //A basic mapping class -> price of particular show Along with particular SeatType
    @ManyToOne
    private Show show;
    @OneToOne
    private SeatType seatType;
    private int price;

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

/*
        1            1
    ShowSeatType -> Show => M : 1
        M             1

       1             1
    ShowSeatType -> SeatType => 1 : 1
       M             1

 */