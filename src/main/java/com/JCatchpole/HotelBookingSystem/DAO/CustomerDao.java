package com.JCatchpole.HotelBookingSystem.DAO;

import java.util.List;

import com.JCatchpole.HotelBookingSystem.model.Customer;

/**
 * 
 * @author John Catchpole 23/03/2022
 * Data Access Object interface to interact with the database for Customer Entities
 */

public interface CustomerDao {
	
	//Method to add Customer to customer table in the database
	public boolean addCustomer(Customer customer);
	//Method to delete a customer by email value from the customer table in the database
	public boolean deleteCustomer(String email);
	//Method to get customer details from the customer table in the database using the customer's email
	public Customer getCustomerDetails(String email);
	//Method to get a list of all customers held within the customer table in the database
	public List<Customer> getAllCustomers();

	

}
