package com.JCatchpole.HotelBookingSystem.appConfig;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.HeaderWriterLogoutHandler;
import org.springframework.security.web.header.writers.ClearSiteDataHeaderWriter;
/**
 * 
 * @author John Catchpole 23/03/2022
 * Spring Security Configuration class
 */

@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter{
	
	//create DataSource object for the jdbc connection
	@Autowired
	private DataSource datasource;
		
	//create passwordEncoder object
	@Autowired
	private PasswordEncoder passwordEncoder;
		
	//setup the security access for the database
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			
		auth.jdbcAuthentication().dataSource(datasource).passwordEncoder(passwordEncoder);
	}
	
	//configuration of what users has access to the various pages
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests()
			.antMatchers("/", "/registerUserPage", "/findRoom", "/getAvailability", "/customLogin", "/searchResultList").permitAll()
			.antMatchers("/regUserHome").hasAnyAuthority("user", "admin")
			.antMatchers("/updateAdminDetails", "/deleteAdminUserPage", "/adminRegistrationPage" ).hasAuthority("admin")
			.antMatchers("/bookingsList", "/accountDetails", "/bookingProceed", "/confirmBooking").hasAuthority("user")
			.and()
			.formLogin().loginPage("/login").loginProcessingUrl("/process-login").defaultSuccessUrl("/userHome", true)
			.and()
			.httpBasic()
			.and()
			//Configure how to handle logout's and what to clean up after logout's
			.logout().addLogoutHandler(new HeaderWriterLogoutHandler(new ClearSiteDataHeaderWriter(ClearSiteDataHeaderWriter.Directive.CACHE,
					ClearSiteDataHeaderWriter.Directive.COOKIES,
					ClearSiteDataHeaderWriter.Directive.STORAGE)))
			.deleteCookies("JSESSIONID")
			.permitAll()
			.and()
			//Configure exception handling for user trying to access restricted resources
			.exceptionHandling().accessDeniedPage("/getAccessDenied");
		}

}
