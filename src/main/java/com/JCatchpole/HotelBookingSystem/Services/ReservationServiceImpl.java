package com.JCatchpole.HotelBookingSystem.Services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JCatchpole.HotelBookingSystem.DAO.ReservationDao;
import com.JCatchpole.HotelBookingSystem.model.Reservation;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	//Inject a ReservationDao object
	@Autowired
	private ReservationDao reservationDao;

	//Add new reservation to the database
	@Override
	public boolean addReservation(Reservation reservation) {
		
		return reservationDao.addReservation(reservation);
	}

	//Delete a reservation from the database by reservation number
	@Override
	public boolean deleteReservation(long resNumber) {
		
		return reservationDao.deleteReservation(resNumber);
	}

	//Get a list of all the reservations held within the database
	@Override
	public List<Reservation> getReservations() {
		
		return reservationDao.getAllReservations();
	}

	//Get a reservation's details from the database by reservation number
	@Override
	public Reservation getReservationDetails(long resNumber) {
		
		return reservationDao.getReservationDetails(resNumber);
	}

	@Override
	public int checkRoomAvailability(String type, Date start, Date end) {
		return reservationDao.getAvailableRooms(type, start, end);
	}

	@Override
	public List<Reservation> getAllCustomerBookings(String username) {
		return reservationDao.getCustomerBookings(username);
		
	}
	
	

}
