package com.JCatchpole.HotelBookingSystem.Services;

import java.sql.Date;
import java.util.List;

import com.JCatchpole.HotelBookingSystem.model.Reservation;

public interface ReservationService {
	
	//Add new reservation to the database
	public boolean addReservation(Reservation reservation);
	
	//Delete a reservation from the database by reservation number
	public boolean deleteReservation(long resNumber);
	
	//Get a list of all the reservations held within the database
	public List<Reservation> getReservations();
	
	//Get a reservation's details from the database by reservation number
	public Reservation getReservationDetails(long resNumber);
	
	//Get the number of rooms available for desired period
	public int checkRoomAvailability(String type, Date start, Date end);
	
	//Get all customer bookings
	public List<Reservation> getAllCustomerBookings(String username);

}
