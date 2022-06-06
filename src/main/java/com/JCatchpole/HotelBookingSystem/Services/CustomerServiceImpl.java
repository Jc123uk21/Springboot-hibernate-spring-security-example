package com.JCatchpole.HotelBookingSystem.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JCatchpole.HotelBookingSystem.DAO.CustomerDao;
import com.JCatchpole.HotelBookingSystem.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	//Inject a CustomerDao object
	@Autowired
	private CustomerDao customerDao;

	//Add new customer to the database
	@Override
	public boolean addNewCustomer(Customer customer) {
	
		System.out.println("service method called");
		return customerDao.addCustomer(customer);
	}

	//Delete a customer from the database
	@Override
	public boolean deleteCustomer(String email) {
		
		return customerDao.deleteCustomer(email);
	}

	//Get a list of all customers held within the database
	@Override
	public List<Customer> getAllCustomers() {
		
		return customerDao.getAllCustomers();
	}

	//Get a customer's details from the database
	@Override
	public Customer getCustomerDetails(String email) {
		
		return customerDao.getCustomerDetails(email);
	}

}
