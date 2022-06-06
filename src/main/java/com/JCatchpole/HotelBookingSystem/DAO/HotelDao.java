package com.JCatchpole.HotelBookingSystem.DAO;

import java.util.List;

import com.JCatchpole.HotelBookingSystem.model.Hotel;

/**
 * 
 * @author John Catchpole 23/03/2022
 * Data Access Object interface to handle interactions with the database for Hotel Entities
 */

public interface HotelDao {
	
	//Method to add a hotel to the hotel table in the database
	public boolean addHotel(Hotel hotel);
	
	//Method to delete a hotel from the hotel table in the database
	public boolean deleteHotel(String email);
	
	//Method to get a list of all hotels in the hotel table in the database
	public List<Hotel> getAllHotels();
	
	//Method to get a hotel details from the hotel table in the database
	public Hotel getHotelDetails(String email);

}
