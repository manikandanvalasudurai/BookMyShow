package com.mani.example.bookmyshowjun25.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeat extends BaseModel{
    @ManyToOne
    private Show show;
    @ManyToOne
    private Seat seat;
    @Enumerated(EnumType.ORDINAL)
    private ShowSeatStatus ShowSeatStatus;
}

/*
    1        1
ShowSeat -> Show => M : 1
    M          1

    1        1
ShowSeat -> Seat => M : 1
    M          1

 */
