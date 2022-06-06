package com.JCatchpole.HotelBookingSystem.Services;

import java.util.List;

import com.JCatchpole.HotelBookingSystem.model.Administrator;



public interface AdministratorService {
	
	//Add new Administrator object to database 
	public boolean addNewAdministrator(Administrator administrator );
	
	//List all Administrator objects in database
	public List<Administrator> getAllAdministrators();
	
	//Delete a Administrator object from the database by Primary key
	public boolean deleteAdministratorByKey(String email);
	
	//Get Administrator object by primary key from the database
	public Administrator getAdministratorByKey(String email);
	
	//Update an Administrators details
	public boolean updateAdminsDetaila(Administrator admin);

}
