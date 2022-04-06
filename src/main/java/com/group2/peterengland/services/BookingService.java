package com.group2.peterengland.services;

import com.group2.peterengland.models.Booking;
import com.group2.peterengland.models.Inventory;
import com.group2.peterengland.models.Offers;
import com.group2.peterengland.models.Tracking;
import com.group2.peterengland.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

	@Autowired
	private BookingRepository bookingRepository;
	@Autowired
	private InventoryServiceImplementation inventoryService;
	@Autowired
	private offersServices offersServices;
	@Autowired
	private TrackingService trackingService;

	public List<Booking> getAllBookings(){
		return bookingRepository.findAll();
	}

	public String createBooking(Booking booking){
		String[] products = booking.getPid().split(",");
		float total = 0;
		LocalDate t=LocalDate.now();
		Date today=java.sql.Date.valueOf(t);

		try {
			for(String p:products){
				int p_id = Integer.parseInt(p);
				Optional<Inventory> product = inventoryService.getProduct(p_id);
				if(product.isPresent()){
					Optional<Offers> offer = offersServices.getOfferOnProductId(p_id);
					if(offer.isPresent()){
						if(offer.get().getStart_date().compareTo(today)<=0 && offer.get().getEnd_date().compareTo(today)>=0){
							total+=product.get().getPrice()-(product.get().getPrice()*(offer.get().getDiscount()/100));
						}
					}else{
						total+=product.get().getPrice();
					}
				}else{
					throw new Exception("product id:"+p_id+" not found");
				}
			}
			booking.setTotal(total);
			Booking newBooking = bookingRepository.save(booking);
			Tracking tracking = new Tracking();
			tracking.setBill_no(newBooking.getId());
			trackingService.addTracking(tracking);
			return newBooking.toString();
		}catch (Exception e){
			return e.getMessage();
		}
	}

	public String getBookingById(int id) {
		try {
			Booking booking = bookingRepository.getById(id);
			return booking.toString();
		}catch (Exception e){
			return "No booking with that id found";
		}
	}

	public String deleteBooking(int id) {
		try{
			bookingRepository.deleteById(id);
			return "Booking deleted";
		}catch (Exception e){
			return "No Booking with that id found";
		}
	}
}
