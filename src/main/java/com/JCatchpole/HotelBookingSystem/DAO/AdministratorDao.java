package com.JCatchpole.HotelBookingSystem.DAO;

import java.util.List;
import com.JCatchpole.HotelBookingSystem.model.Administrator;


/**
 * 
 * @author John Catchpole 23/03/2022
 * Data Access Object interface for Administrator Entities
 */

public interface AdministratorDao {

	//Method to add administrator to the administrator table in the database
	public boolean addAdministrator(Administrator admin);
	
	//Method to delete a administrator from the administrator table in the database
	public boolean deleteAdminUser(String email);
	
	//Method to retrieve a list of all the administrator users held within the administrator table in the database
	public List<Administrator> getAllAdminUsers();
	
	//Method to retrieve the details of an individual administrator 
	public Administrator getAdminUsersDetails(String email);
	
	//Method to update an administrators details
	public boolean updateAdminDetails(Administrator admin);
}
