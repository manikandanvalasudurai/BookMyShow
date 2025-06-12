package com.mani.example.bookmyshowjun25.controllers;

import com.mani.example.bookmyshowjun25.dtos.CreateBookingRequestDto;
import com.mani.example.bookmyshowjun25.dtos.CreateBookingResponseDto;
import com.mani.example.bookmyshowjun25.dtos.ResponseStatus;
import com.mani.example.bookmyshowjun25.exceptions.ShowSeatNotFoundException;
import com.mani.example.bookmyshowjun25.exceptions.UserNotFoundException;
import com.mani.example.bookmyshowjun25.models.Booking;
import com.mani.example.bookmyshowjun25.services.BookingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    private BookingService bookingService;
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }
    @PostMapping
    public CreateBookingResponseDto createBooking(@RequestBody CreateBookingRequestDto requestDto) throws UserNotFoundException, ShowSeatNotFoundException {
        CreateBookingResponseDto responseDto = new CreateBookingResponseDto();
        Booking booking = null;
        booking = bookingService.createBooking(
                requestDto.getShowSeatIds(),
                requestDto.getUserId()
        );
        //if booking obj null means having any exception then
        responseDto.setBooking(booking);
        responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        if(booking.equals(null)) {
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDto;
    }
}
