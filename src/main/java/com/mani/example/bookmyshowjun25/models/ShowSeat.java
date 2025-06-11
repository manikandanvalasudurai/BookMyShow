package com.mani.example.bookmyshowjun25.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class ShowSeat extends BaseModel{
    @ManyToOne
    private Show show;
    @ManyToOne
    private Seat seat;
    @Enumerated(EnumType.ORDINAL)
    private ShowSeatStatus ShowSeatStatus;

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public com.mani.example.bookmyshowjun25.models.ShowSeatStatus getShowSeatStatus() {
        return ShowSeatStatus;
    }

    public void setShowSeatStatus(com.mani.example.bookmyshowjun25.models.ShowSeatStatus showSeatStatus) {
        ShowSeatStatus = showSeatStatus;
    }
}

/*
    1        1
ShowSeat -> Show => M : 1
    M          1

    1        1
ShowSeat -> Seat => M : 1
    M          1

 */
