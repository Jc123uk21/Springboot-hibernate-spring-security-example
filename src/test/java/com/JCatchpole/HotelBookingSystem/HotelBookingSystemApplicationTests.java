package com.JCatchpole.HotelBookingSystem;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import javax.servlet.ServletContext;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import com.JCatchpole.HotelBookingSystem.appConfig.WebMvcConfig;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {WebMvcConfig.class})
@WebAppConfiguration
class HotelBookingSystemApplicationTests {
	
	//Autowired WebApplicationCotext to configure web context beans
	private WebApplicationContext webApplicationContext;
	
	//Autowired MockMvc object to provide web application beans for tests
	private MockMvc mockMvc;
	
	//Setup MockMvc object for all tests
	public void setUp() throws Exception{
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
	}
	
	//Test WebApplicationContext Configuration
	@Test
	public void givenWac_whenServletContext_thenItProvidesGreetController() {
		ServletContext servletContext = webApplicationContext.getServletContext();
	    
	    assertNotNull(servletContext);
	    assertTrue(servletContext instanceof MockServletContext);
	    assertNotNull(webApplicationContext.getBean("serviceController"));
	}
	
	
	//Test home page end-point
	@Test
	public void testHomePageURI() throws Exception{
		this.mockMvc.perform(get("/")).andDo(print()).andExpect(view().name("index"));
	}
	
	
	//Test findRoom page end-point
	@Test
	public void testSearchPageURI() throws Exception{
		this.mockMvc.perform(get("/findRoom")).andDo(print()).andExpect(view().name("findRoomPage"));
	}
	
	//Test register page end-point
	@Test
	public void testRegisterUserURI() throws Exception{
		this.mockMvc.perform(get("/registerUserPage")).andDo(print()).andExpect(view().name("registerPage"));
	}
	
	//Test login page end-point
		@Test
		public void testLoginPageURI() throws Exception{
			this.mockMvc.perform(get("/login")).andDo(print()).andExpect(view().name("customLogin"));
		}



}
