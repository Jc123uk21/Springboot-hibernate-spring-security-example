package com.JCatchpole.HotelBookingSystem.Controllers;

import java.security.Principal;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.JCatchpole.HotelBookingSystem.Services.HotelService;
import com.JCatchpole.HotelBookingSystem.model.Hotel;

/**
 * 
 * @author John Catchpole 23/03/2022
 * Controller class  which contains handler method which interact with the service layer to conduct CRUD actions
 * in regards to Hotel processes
 */
@Controller
public class HotelController {
	
	
	//Autowired Hotel object
	@Autowired
	private Hotel hotel;
	
	//Autowired HotelService object
	@Autowired
	private HotelService hotelService;
	
	
	//Handler method to retrieve the add Hotel Page
	@GetMapping("/addHotelPage")
	public String getAddHotelPage(Model model, Principal principal) {
		
		//Capture the current username and store it to a variable 
		String username = principal.getName();
		
		//Add the username captured and a hotel object to the model used by the view
		model.addAttribute("username", username);
		model.addAttribute("newHotel", hotel);
		
		//Return the requested jsp
		return "addHotelPage";
	}
	
	
	//Handler method to add a hotel to database
	@Transactional
	@PostMapping("/addHotel")
	public String addHotel(Hotel aHotel, Principal principal, Model model) {
		
		//Capture the current users username
		String username = principal.getName();
		
		//Add username to the model
		model.addAttribute("username", username);
		
		
		if(hotelService.addHotel(aHotel) == true) {
			return "hotelAddedPage";
		}else {
			return "unableToAddHotelPage";
		}
	}
	
	//Handler method to retrieve the delete a hotel page
	@GetMapping("/deleteHotelPage")
	public String getDeleteHotelPage(Model model, Principal principal) {
		
		//Capture username and store it to a variable
		String username = principal.getName();
		
		//Add username to the model held by the view
		model.addAttribute("username", username);
		//Retrieve the jsp 
		return "hotelDeletePage";
	}
	
	//Handler method to delete a hotel from the database by key (Email)
	@Transactional
	@PostMapping("/deleteHotel")
	public String deleteHotel(@RequestParam String email) {
		
		if(hotelService.deleteHotel(email)==true) {
			return "hotelDeleteSucessfulPage";
		}else {
			return "unableToDeleteHotelPage";
		}
	}

}
