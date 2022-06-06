package com.JCatchpole.HotelBookingSystem.DAO;


import java.util.List;

import com.JCatchpole.HotelBookingSystem.model.Room;

/**
 * 
 * @author John Catchpole 23/03/2022
 * Data Access Object interface to interact with the database for Room Entities
 */

public interface RoomDao {
	//method to add a room to the room table in the database
	public boolean addRoom(Room room);
	
	//Method to delete a room from room table in the database
	public boolean deleteRoom(int number);
	
	//Method to get a list of all rooms in the room table in the database
	public List<Room> getAllRooms();
	
	//Method to get a room's detail from the room table in the database
	public Room getRoomDetails(int number);

}
