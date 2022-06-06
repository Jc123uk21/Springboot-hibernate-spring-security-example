package com.JCatchpole.HotelBookingSystem.Services;

import java.util.List;

import com.JCatchpole.HotelBookingSystem.model.Customer;

public interface CustomerService {
	
	//Add new customer to the database
	public boolean addNewCustomer(Customer customer);
	
	//delete a customer from the database
	public boolean deleteCustomer(String email);
	
	//Get a list of all customers held within the database
	public List<Customer> getAllCustomers();
	
	//Get a customer's details from the database
	public Customer getCustomerDetails(String email);

}
