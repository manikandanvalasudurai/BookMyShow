package com.mani.example.bookmyshowjun25.repositories;

import com.mani.example.bookmyshowjun25.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;
@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>{
    Booking save(Booking booking);
}
