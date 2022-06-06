package com.JCatchpole.HotelBookingSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * 
 * @author John Catchpole
 *
 */

@SpringBootApplication
@ComponentScan({"com.JCatchpole.HotelBookingSystem", "com.JCatchpole.HotelBookingSystem.Controllers"})
public class HotelBookingSystemApplication extends SpringBootServletInitializer{
	
	 @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	        return builder.sources(HotelBookingSystemApplication.class);
	 }

	public static void main(String[] args) {
		SpringApplication.run(HotelBookingSystemApplication.class, args);		
	}
	
	
	
	

}
