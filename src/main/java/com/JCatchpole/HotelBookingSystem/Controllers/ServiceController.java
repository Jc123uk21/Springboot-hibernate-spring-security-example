	package com.JCatchpole.HotelBookingSystem.Controllers;


import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.JCatchpole.HotelBookingSystem.model.Customer;
import com.JCatchpole.HotelBookingSystem.model.Reservation;

/**
 * 
 * @author John Catchpole 23/03/2022
 * Controller class to handle requests which are deemed as business service actions, the actions which are required to complete a business process
 *  such as retrieve static or dynamic content but do not interact with the service layer to conducted CRUD actions  
 */


@Controller
public class ServiceController {
	
	//Autowired customer object
	@Autowired
	private Customer newCustomer;
		
	//Autowired reservation object
	@Autowired
	private Reservation newReservation;
	
	//Handler method to retrieve home page
	@RequestMapping(value = "/")
	public String getHome() {
		return "index";
	}
	
	//Handler method to retrieve the registered users home page
	@GetMapping("/userHome")
	public String getUserHome(Model model, Principal principal) {
		String username = principal.getName();
		model.addAttribute("username", username);
		return "regUserHome";
	}
	
	//Handler method to handle requests for retrieving the administrator's home page
	@GetMapping("/adminHome")
	public String getAdmiinHome(Principal pricipal, Model model) {
			
		return "adminHomePage";
	}
	
	//Handler method to retrieve the register user page
	@GetMapping("/registerUserPage")
	public String getRegisterPage(Model model) {
		model.addAttribute("customer", newCustomer);
		return "registerPage";
	}
	
	//Handler method to login a user
	@GetMapping("login")
	public String getLoginPage(Model model) {
		return "index";
	}
	
	
	//Handler method to logout a user
	@GetMapping("logout")
	public String logout() {
		return "";
	}
	
	//Handler method to retrieve the search hotels page
	@GetMapping("/findRoom")
	public String getSearchPage(Model model, Principal principal) {
			model.addAttribute("reservation", newReservation);
			return "findRoomPage";
	}	
	
	//Handler method to retrieve the page to unregister a user 
	@GetMapping("unregisterCustomerPage")
	public String unregisterUserPage(Model model) {
		return "unregisterCustomePage";
	}

	//Handler method to retrieve the post access denied page
	@PostMapping("/getAccessDenied")
	public String postAccessDeniedPage() {
		return "accessDenied";
	}
	
	//Handler method to retrieve the get access denied page
	@GetMapping("/getAccessDenied")
	public String getAccessDeniedPage() {
		return "accessDenied";
	}	
}
