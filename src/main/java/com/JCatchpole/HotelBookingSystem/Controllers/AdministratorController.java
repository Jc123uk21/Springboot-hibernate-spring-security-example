package com.JCatchpole.HotelBookingSystem.Controllers;

import java.security.Principal;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.JCatchpole.HotelBookingSystem.Services.AdministratorService;
import com.JCatchpole.HotelBookingSystem.model.Administrator;


/**
 * 
 * @author john catchpole 23/03/2022
 * Controller class to handle Administrator which contains handler method which interact with the service layer to conduct CRUD actions
 * regarding Administrator processes
 */

@Controller
public class AdministratorController {
	
	//Autowire(inject) a password encoder object
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	//Autowired Administrator object
	@Autowired
	private Administrator administrator;
	
	//Autowired AdinistratorService object
	@Autowired
	private AdministratorService adminService;
	
	
	
	//Handler method to handle requests for retrieving the page for adding new administrators to the system
	@GetMapping("/adminRegistrationPage")
	public String getAddAdminPage(Model model,Principal principal) {
		model.addAttribute("newAdministrator", administrator);
		return "adminRegisterPage";
	}
	
	//Handler method to handle requests for retrieving the delete administrator page
	@GetMapping("/deleteAdminUserPage")
	public String getDeleteAdminPage(Principal principal, Model model) {
		//Capture users username and add it to the model
		String username = principal.getName();
		model.addAttribute("username", username);
		return "deleteAdminPage";
	}
	
	//Handler method to retrieve the page required to update an administrator users details
	@GetMapping("/updateAdminDetails")
	public String getUpdateAdminDetailsPage(Principal principal, Model model) {
		
		//Capture users username and add it to the model
				String username = principal.getName();
				model.addAttribute("username", username);
				
				//Setup administrator object to the current administrators users details
				administrator = adminService.getAdministratorByKey(username);
				
				System.out.println(administrator.toString());
				
				
				//Add Administrator object to model
				model.addAttribute("administrator", administrator);
				return "updateAdminDetailsPage";
	}
	
	//Handler method to handle requests for adding a new administrator user to the system
	@PostMapping("/addAdminUser")
	public String addAdminUser(@Valid @ModelAttribute("newAdministrator") Administrator administrator, BindingResult result) {
		
	//Check data collected for error's
		if(result.hasErrors()) {
				return "formErrorPage";	
			}
		else {
		
			//Encode the provided password 
			administrator.setPassword(passwordEncoder.encode(administrator.getPassword()));
			//check new administrator object has been added to database and redirect to the appropriate resource depending on the outcome
			if(adminService.addNewAdministrator(administrator) == true) {
				return "regUserHome";
			}
			else {
				return "errorPage";
			}
		}
	}
	
	//Handler method to handle requests from the deleteAdminPage to delete the provided administrator user from the system
	@PostMapping("/deleteAdminUser")
	public String deleteAdminUser(@RequestParam String email, Principal principal, Model model) {
		
		//Check administrator user has beeen deleted from the database and redirect to the appropriate resource depending on the outcome
		if(adminService.deleteAdministratorByKey(email) == true) {
			return "adminUserDeletedPage";
		}
		else {
			return "adminErrorPage";
		}
	}
	
	@PostMapping("/updateAdministrator")
	public String updatAdminDetails(@ModelAttribute("administrator") Administrator administrator, BindingResult result,
Principal principal, Model model) {
		
		//Capture and add current username to the model
		String username = principal.getName();
		model.addAttribute("username", username);
		
		
		if(adminService.updateAdminsDetaila(administrator) == true) {
			return "detailsUpdatedPage";
		}
		else{
			return "errorPage";
		}
	}

}
