package com.JCatchpole.HotelBookingSystem.Controllers;



import java.security.Principal;
import java.sql.Date;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.JCatchpole.HotelBookingSystem.Services.CustomerService;
import com.JCatchpole.HotelBookingSystem.Services.HotelService;
import com.JCatchpole.HotelBookingSystem.Services.ReservationService;
import com.JCatchpole.HotelBookingSystem.model.Customer;
import com.JCatchpole.HotelBookingSystem.model.Hotel;
import com.JCatchpole.HotelBookingSystem.model.Reservation;
import com.JCatchpole.HotelBookingSystem.model.Room;

/**
 * 
 * @author John Catchpole 23/03/2022
 * Controller class  which contains handler method which interact with the service layer to conduct CRUD actions
 * in regards to Reservation processes
 */

@Controller
public class ReservationController {
	
	//Autowired customer object
		@Autowired
		private Customer newCustomer;
		
		//Autowired CustomerService object
		@Autowired
		private CustomerService customerService;
				
		//Autowired service object
		@Autowired
		private ReservationService reservationService;
		
		//Autowired Hotel object
		@Autowired
		private Hotel hotel;
		
		//Autowired Room object
		@Autowired
		private Room room;
		
		//Autowired HotelService object
		@Autowired
		private HotelService hotelService;
		
		//Autowired reservation object
		@Autowired
		private Reservation newReservation;
		
	
	
	//Method to find room availability
	
	@RequestMapping("/getAvailability")
	public String getRoomAvailability(@RequestParam("roomType") String roomType, @RequestParam("startDate") Date startDate, 
			@RequestParam("endDate") Date endDate, Model model) { 
		
		//Create an ArayList to hold reservations
		ArrayList<Reservation> resultList = new ArrayList<Reservation>();
		
		//Setup hotel object
		hotel = hotelService.geHotelDetails("Melrose@gmail.com");
		
		//Retrieve the number of room of a particular type reserved for a period
		int roomsTaken = reservationService.checkRoomAvailability(roomType, startDate, endDate);
		
		//Setup room object
		if(roomType.equals("familyRoom")) {
			//Setup room object
			room.setRoomType("familyRoom");
			room.setMaxCapacity();
			room.setRate();
			room.setLocation("3rd level");
			
			//Check availability of room for period
			if(roomsTaken < hotel.getNumberOffamilyRooms()) {
				
				//Set Room object number
				room.setNumber(roomsTaken + 1);
				
				//setup initial reservation object
				newReservation.setStartDate(startDate);
				newReservation.setEndDate(endDate);
				newReservation.setRoom(room);
				newReservation.setTotalCost();
				
				//Add reservation to result list
				resultList.add(newReservation);
				//Add reservation object to the  model to render in view
				model.addAttribute("resultList", resultList);
				
				return "searchResultList";	
			}else {
				return "noAvailabilityPage";
			}
		}else if(roomType.equals("kingSize")){
			
			 //Setup room object
			 room.setRoomType("kingSize");
			 room.setMaxCapacity();
			 room.setRate();
			 room.setLocation("2nd level");
			
			if(roomsTaken < hotel.getNumberOfKingSizeRooms()) {
				
				//Set Room object number
				room.setNumber(roomsTaken + 1);
				
				//setup initial reservation object
				newReservation.setStartDate(startDate);
				newReservation.setEndDate(endDate);
				newReservation.setRoom(room);
				newReservation.setTotalCost();
				
				//Add reservation to result list
				resultList.add(newReservation);
				//Add reservation object to the model to render in view				
				model.addAttribute("resultList", resultList);
				
				return "searchResultList";
			}else {
				return "noAvailabilityPage";
			}
			
		}else if(roomType.equals("double")) {
			//Setup room object
			room.setRoomType("double");
			room.setMaxCapacity();
			room.setRate();
			room.setLocation("1st floor");
			
			if(roomsTaken < hotel.getNumberOfDoubleRooms()) {
				
				//Set Room object number
				room.setNumber(roomsTaken + 1);
				
				//setup initial reservation object
				newReservation.setStartDate(startDate);
				newReservation.setEndDate(endDate);
				newReservation.setRoom(room);
				newReservation.setTotalCost();
				
				//Add reservation to result list
				resultList.add(newReservation);
				//Add reservation object to the model to render in view				
				model.addAttribute("resultList", resultList);
				
				return "searchResultList";
			}else {
				return "noAvailabilityPage";
			}
		
		}else if(roomType.equals("single")) {
			
			//Setup room object
			room.setRoomType("single");
			room.setMaxCapacity();
			room.setRate();
			room.setLocation("ground");
			
			if(roomsTaken < hotel.getNumberOfSingleRooms()) {
				
				//Set Room object number
				room.setNumber(roomsTaken + 1);
				
				//setup initial reservation object
				newReservation.setStartDate(startDate);
				newReservation.setEndDate(endDate);
				newReservation.setRoom(room);
				newReservation.setTotalCost();
				
				//Add reservation to result list
				resultList.add(newReservation);
				//Add reservation object to model to render in view
				model.addAttribute("resultList", resultList);
				
				return "searchResultList";
			}else {
				return "noAvailabilityPage";
			}
		}
		
		else {
			return "errorPage";
		}	
	}
	
	//Handler method to setup reservation and retrieve booking confirmation page
		@RequestMapping("/bookingProceed")
		public String getBookingProceedPage(@ModelAttribute("resultList") ArrayList<Reservation> resultList, BindingResult result ,Model model, Principal principal) {
			
			//Capture logged in username and add to model to render in view
			String username = principal.getName();
			model.addAttribute("username", username);
			
			//Setup Customer object
			newCustomer = customerService.getCustomerDetails(username);
			newReservation.setCustomer(newCustomer);
			
			//Capture and setup reservation object
			for(int i = 0; i < resultList.size(); i ++) {
				
			//Set Reservation object attribute values
			newReservation.setStartDate(resultList.get(i).getStartDate());
			newReservation.setEndDate(resultList.get(i).getEndDate());
			newReservation.setRoom(resultList.get(i).getRoom());
			newReservation.setTotalCost();
			}
			
			//Add reservation to model
			model.addAttribute("reservation", newReservation);
			
			//Create a arrayList to and add the completed reservation too it
			ArrayList<Reservation> available = new ArrayList<Reservation>();
			available.add(newReservation);
			
			model.addAttribute("reservations", available);
			
			return "bookingConfirmation";
		
		}
	
	//Hnadler method to complete the booking once confirmed
		@RequestMapping("/confirmBooking")
		public String completeBookingProcess(@ModelAttribute("reservations") ArrayList<Reservation> available, BindingResult result ,Model model, Principal principal) {
			
			//Capture and store current logged in username
			String username = principal.getName();
					
			//Add username to the model
			model.addAttribute("username", username);
			
			//Add reservation list to model
			model.addAttribute("reservations", available);
			
			for(int i = 0; i < available.size(); i++) {
				newReservation = available.get(i);
			}
			
			//Add Reservation object to model
			model.addAttribute("reservation", newReservation);
			
			System.out.println(newReservation.toString());
			
			if(reservationService.addReservation(newReservation) == true) {
				return "completeBooking";
			}else {
				return "errorPage";
			}
		}
}
