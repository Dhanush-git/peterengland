package com.group2.peterengland.controllers;

import java.util.List;

import com.group2.peterengland.models.Booking;
import com.group2.peterengland.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping
    public List<Booking> getAllBookings(){
        return bookingService.getAllBookings();
    }

    @PostMapping
    public String newBooking(@RequestBody Booking booking){
        return bookingService.createBooking(booking);
    }

    @GetMapping("/{id}")
    public String getBookingById(@PathVariable int id){
        return bookingService.getBookingById(id);
    }

    @DeleteMapping()
    public String deleteBooking(@RequestParam int id){
        return bookingService.deleteBooking(id);
    }
}
