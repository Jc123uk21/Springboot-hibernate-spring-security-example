package com.JCatchpole.HotelBookingSystem.Services;


import java.util.List;

import com.JCatchpole.HotelBookingSystem.model.Room;

public interface RoomService {
	
	//Add a room to the database
	public boolean addRoom(Room room);
	
	//Delete a room from the database by room number
	public boolean deleteRoom(int number);
	
	//Get a list of all the rooms held within the database 
	public List<Room> getRooms();
	
	//Get a room's details from the database by room number
	public Room getRoomDetails(int number);

}
