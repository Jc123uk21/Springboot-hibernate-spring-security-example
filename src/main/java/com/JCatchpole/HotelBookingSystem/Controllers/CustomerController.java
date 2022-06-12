
package com.JCatchpole.HotelBookingSystem.Controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.JCatchpole.HotelBookingSystem.Services.CustomerService;
import com.JCatchpole.HotelBookingSystem.Services.ReservationService;
import com.JCatchpole.HotelBookingSystem.model.Customer;
import com.JCatchpole.HotelBookingSystem.model.Reservation;

/**
 * 
 * @author John Catchpole 23/03/2022
 * Controller class  which contains handler method which interact with the service layer to conduct CRUD actions
 * in regards to Customer processes
 */

@Controller
public class CustomerController {
	
	//Autowired Customer object
	private Customer customer;
	
	//Autowire(inject) service object
	@Autowired
	private CustomerService customerService;
	
	//Autowire(inject) a password encoder object
	@Autowired
	private PasswordEncoder passwordEncoder;

	//Autowire reservation Service object 
	@Autowired
	private ReservationService reservationService;
	
	

	//Handler method to register a customer user within the database
	@RequestMapping(value = "registerCustomer", method = RequestMethod.POST)
	public String registerCustomerUser(@Valid @ModelAttribute("customer") Customer customer, BindingResult result) {
		
			System.out.println(customer.toString());		
			
			//Encode the newCustomer password 
			customer.setPassword(passwordEncoder.encode(customer.getPassword()));			
			
			//Check if the object has been added to the database or not and redirect to the appropriate resource
			if(customerService.addNewCustomer(customer)==true) {
				return "/customLogin";
			}else {
				
				
				return "unableToAddCustomerPage";
			}
	}
	
	
	//Handler method to retrieve customer booking list page
	@GetMapping("/bookingsList")
	public String getBookingListPage(Model model, Principal principal) {
		
		//Capture the current users username
		String username = principal.getName();
		
		//Capture customer booking from database into ArrayList
		List<Reservation> bookings = reservationService.getAllCustomerBookings(username);
		
		//Add current username to the model
		model.addAttribute("username", username);
		
		//Add the list of customer bookings to the model
		model.addAttribute("myBookings", bookings);
		
		System.out.println(bookings.toString());
		
		return "myBookingsPage";
	}
	
	
	//Handler method to retrieve account details page
	@GetMapping("/accountDetails")
	public String getAccountDetails(Model model, Principal principal) {
		
		//Capture current username
		String username = principal.getName();
		
		//Get customer details from database and store to customer object
		customer = customerService.getCustomerDetails(username);
		
		System.out.println(customer.toString());
		
		//Store customer object to arrayList
		ArrayList<Customer> users = new ArrayList<Customer>();
		users.add(customer);
		
		//add username and customer arraylist to model
		model.addAttribute("username", username);
		model.addAttribute("user", users);
		
		return "userAccountPage";
	}
	
	//Handler method to remove a user from the system's database
	@PostMapping("unregisterUser")
	public String unregisterUser(Model model) {
		return "";
	}
	
	
	

}
