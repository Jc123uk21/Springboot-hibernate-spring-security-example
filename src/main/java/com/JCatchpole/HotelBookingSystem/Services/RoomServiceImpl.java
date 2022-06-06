package com.JCatchpole.HotelBookingSystem.Services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JCatchpole.HotelBookingSystem.DAO.RoomDao;
import com.JCatchpole.HotelBookingSystem.model.Room;

@Service
public class RoomServiceImpl implements RoomService {
	
	//Inject a RoomDao object
	@Autowired
	private RoomDao roomDao;

	//Add a room to the database
	@Override
	public boolean addRoom(Room room) {
		
		return roomDao.addRoom(room);
	}

	//Delete a room from the database by room number
	@Override
	public boolean deleteRoom(int number) {
		
		return roomDao.deleteRoom(number);
	}

	//Get a list of all the rooms held within the database 
	@Override
	public List<Room> getRooms() {
		
		return roomDao.getAllRooms();
	}

	//Get a room's details from the database by room number
	@Override
	public Room getRoomDetails(int number) {
		
		return roomDao.getRoomDetails(number);
	}
	
	

}
