package com.JCatchpole.HotelBookingSystem.appConfig;



import javax.sql.DataSource;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.JCatchpole.HotelBookingSystem.DAO.HotelDao;
import com.JCatchpole.HotelBookingSystem.DAO.HotelDaoImpl;
import com.JCatchpole.HotelBookingSystem.model.Administrator;
import com.JCatchpole.HotelBookingSystem.model.Customer;
import com.JCatchpole.HotelBookingSystem.model.Hotel;
import com.JCatchpole.HotelBookingSystem.model.Reservation;
import com.JCatchpole.HotelBookingSystem.model.Room;

/**
 * 
 * @author John Catchpole
 *
 */

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"HotelBookingSystem"})
public class WebMvcConfig implements WebMvcConfigurer {
	
	
	    //Configure the view resolver
		@Bean
		    public InternalResourceViewResolver resolver() {
		        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		        resolver.setViewClass(JstlView.class);
		        resolver.setPrefix("/WEB-INF/view/");
		        resolver.setSuffix(".jsp");
		        return resolver;
		    }
		
		  //Configure resources folder location
		  @Override
		    public void addResourceHandlers(ResourceHandlerRegistry registry) {
		        registry
		            .addResourceHandler("/resources/**")
		            .addResourceLocations("/resources/");
		    }
		  	
		    
		   //Configure message resource
		    @Bean
		    public MessageSource messageSource() {
		       ResourceBundleMessageSource source = new ResourceBundleMessageSource();
		       source.setBasename("messages");
		       return source;
		    }
		  
		    //Configure validator bean
		    @Override
		    public org.springframework.validation.Validator getValidator() {
		       LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
		       validator.setValidationMessageSource(messageSource());
		       return validator;
		    }
		    
			//Configure the data source
			@Bean
			public DataSource dataSource() {
				// create new datasource object
				DriverManagerDataSource dataSource = new DriverManagerDataSource();
				//set datasource connection attributes
				dataSource.setUsername("root");
				dataSource.setPassword("root");
				dataSource.setUrl("jdbc:mysql://localhost:3306/hotelreservationsystem?useTimezone=true&serverTimezone=UTC");
				dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
				return dataSource;
			}
			
			//Create a BCrypt password encoder to handle passwords
			@Bean
			public PasswordEncoder passwordEncoder() {
				PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(4);
				return passwordEncoder;
				
			}
			
			//Administrator model bean
			@Bean
			public Administrator administrator() {
				return new Administrator();		
			}
			
			//Customer model bean
			@Bean 
			public Customer customer() {
				return new Customer();
			}
			
			//Hotel model bean
			@Bean
			public Hotel hotel() {
				return new Hotel();	
			}
			
			//Reservation model bean
			@Bean 
			public Reservation reservation() {
				return new Reservation();
			}
			
			//Room model bean
			@Bean
			public Room room() {
				return new Room();
			}
			
			//HotelDao object bean
			@Bean
			public HotelDao hotelDao() {
				return new HotelDaoImpl();
			}
}

