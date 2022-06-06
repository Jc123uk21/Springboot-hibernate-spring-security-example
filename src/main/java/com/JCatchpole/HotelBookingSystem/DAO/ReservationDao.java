package com.JCatchpole.HotelBookingSystem.DAO;

import java.sql.Date;
import java.util.List;

/**
 * 
 * @author John Catchpole 23/03/2022
 * Data Access Object interface for Customer Entities
 */


import com.JCatchpole.HotelBookingSystem.model.Reservation;

/**
 * 
 * @author John Catchpole 23/03/2022
 * Data Access Object interface to handle interactions with the database for Reservation Entities
 */

public interface ReservationDao {
	//Method to add a reservation to the reservation table in the database
	public boolean addReservation(Reservation reservation);
	
	//Method to delete a reservation from the reservation table in the database
	public boolean deleteReservation(long resNumber);
	
	//Method to get a list of all the reservations held in the reservation table in the database
	public List<Reservation> getAllReservations();
	
	//Method to get a reservation's details held in the reservation table in the database
	public Reservation getReservationDetails(long resNumber);
	
	//Method to check availability for room of a particular type with the same start and end date,returns he number of reserved rooms
	public int getAvailableRooms(String type, Date start, Date end);
	
	//Method to get all reservations linked to a customer
	public List<Reservation> getCustomerBookings(String username);
	
	//Method to get an available room number for a reservation
	public int getAvailableRoomNumber(String type, Date start, Date end);

}
