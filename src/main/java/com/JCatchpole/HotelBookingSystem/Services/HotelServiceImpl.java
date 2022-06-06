package com.JCatchpole.HotelBookingSystem.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JCatchpole.HotelBookingSystem.DAO.HotelDao;
import com.JCatchpole.HotelBookingSystem.model.Hotel;

@Service
public class HotelServiceImpl implements HotelService {
	
	//Inject a HotelDao object
	@Autowired
	private HotelDao hotelDao;

	//Add new hotel to the database
	@Override
	public boolean addHotel(Hotel hotel) {
		
		return hotelDao.addHotel(hotel);
	}

	//Delete a hotel from the database by email
	@Override
	public boolean deleteHotel(String email) {
		
		return hotelDao.deleteHotel(email);
	}

	//Get a list of all hotels held within the database
	@Override
	public List<Hotel> getAllHotels() {
		
		return hotelDao.getAllHotels();
	}

	//Get a hotel's details from the database by email
	@Override
	public Hotel geHotelDetails(String email) {
		
		return hotelDao.getHotelDetails(email);
	}

}
