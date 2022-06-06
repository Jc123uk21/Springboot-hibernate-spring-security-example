package com.JCatchpole.HotelBookingSystem.Services;

import java.util.List;

import com.JCatchpole.HotelBookingSystem.model.Hotel;

public interface HotelService {
	
	//Add new hotel to the database
	public boolean addHotel(Hotel hotel);
	
	//Delete a hotel from the database by email
	public boolean deleteHotel(String email);
	
	//Get a list of all hotels held within the database
	public List<Hotel> getAllHotels();
	
	//Get a hotel's details from the database by email
	public Hotel geHotelDetails(String email);

}
