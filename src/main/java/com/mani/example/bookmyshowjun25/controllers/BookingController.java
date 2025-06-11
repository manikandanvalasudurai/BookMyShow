package com.mani.example.bookmyshowjun25.controllers;

import com.mani.example.bookmyshowjun25.dtos.CreateBookingRequestDto;
import com.mani.example.bookmyshowjun25.dtos.CreateBookingResponseDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    @PostMapping
    public CreateBookingResponseDto createBooking(@RequestBody CreateBookingRequestDto requestDto){
        return null;
    }


}
