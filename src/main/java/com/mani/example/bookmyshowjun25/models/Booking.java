package com.mani.example.bookmyshowjun25.models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity(name ="bookings")
public class Booking extends BaseModel{
    @ManyToOne
    private User user;
    @OneToMany
    private List<ShowSeat> showSeats;
    @Enumerated(EnumType.ORDINAL)
    private BookingStatus bookingStatus;
    private int amount;
    @OneToMany
    private List<Payment> payments;
    private Date bookedAt;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<ShowSeat> getShowSeats() {
        return showSeats;
    }

    public void setShowSeats(List<ShowSeat> showSeats) {
        this.showSeats = showSeats;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public Date getBookedAt() {
        return bookedAt;
    }

    public void setBookedAt(Date bookedAt) {
        this.bookedAt = bookedAt;
    }
}
/*
  1         1
Booking -> User  => M : 1
  M         1

    1        M
Booking -> ShowSeat => 1 : M
    1        1

    1         M
Booking -> Payment  => 1 : M
    1         1

 */
