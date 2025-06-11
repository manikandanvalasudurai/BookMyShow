package com.mani.example.bookmyshowjun25.dtos;

import com.mani.example.bookmyshowjun25.models.Booking;


public class CreateBookingResponseDto {
    private Booking booking;
    private ResponseStatus responseStatus;

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }
}
