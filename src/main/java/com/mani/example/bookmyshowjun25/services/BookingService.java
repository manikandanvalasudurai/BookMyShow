package com.mani.example.bookmyshowjun25.services;

import com.mani.example.bookmyshowjun25.exceptions.ShowSeatNotFoundException;
import com.mani.example.bookmyshowjun25.exceptions.UserNotFoundException;
import com.mani.example.bookmyshowjun25.models.*;
import com.mani.example.bookmyshowjun25.repositories.ShowSeatRepository;
import com.mani.example.bookmyshowjun25.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private UserRepository userRepository;
    private ShowSeatRepository showSeatRepository;
    private PriceCalculatorService priceCalculatorService;

    public BookingService(UserRepository userRepository, ShowSeatRepository showSeatRepository,PriceCalculatorService priceCalculatorService) {
        this.userRepository = userRepository;
        this.showSeatRepository = showSeatRepository;
        this.priceCalculatorService = priceCalculatorService;
    }
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking createBooking(List<Long> showSeatId,Long userId) throws UserNotFoundException, ShowSeatNotFoundException {
        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isEmpty()){
            throw new UserNotFoundException("User with " + userId + "did have a Registered Account");
        }
        User user = optionalUser.get();
        List<ShowSeat> showSeats = showSeatRepository.findByIdIn(showSeatId);
        for(ShowSeat showSeat : showSeats){
            if(!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)){
                throw new ShowSeatNotFoundException("Seats with showId : "+
                        showSeat.getShow().getId() + " and seatId : " +
                        showSeat.getSeat().getId() + " are not available");
            }
        }
        List<ShowSeat> savedShowSeats = showSeatRepository.findAllById(showSeatId);
        for(ShowSeat showSeat : showSeats){
            showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);
            savedShowSeats.add(showSeatRepository.save(showSeat));
        }
        //Create the Booking object with status  as PENDING
        Booking booking = new Booking();
        booking.setShowSeats(savedShowSeats);
        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setUser(user);
        booking.setAmount(priceCalculatorService.calculatePrice(savedShowSeats));
        return booking;
    }
}
/*
        1. Fetch the user from userId.
        2. if user not found, then throw an exception.
        3. Fetch the ShowSeat objects from the Database.
        4. Check if showSeats are available.
        5. If NOT, throw an exception.
        ----------------TAKE A LOCK---------------
        6. Check the showSeat status again.
        7. Change the showSeat status to BLOCKED.
        ----------------RELEASE THE LOCK-----------
        8. Create the booking with PENDING status. Object is make the Booking Object as Pending since That needs to be Assumptions of Redirection of Payment
        9. Move to the payment page.
         */
