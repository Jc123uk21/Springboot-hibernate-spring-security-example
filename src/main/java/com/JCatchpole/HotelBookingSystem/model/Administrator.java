package com.JCatchpole.HotelBookingSystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation .constraints.Size;
import org.hibernate.validator.constraints.Email;

@Entity
@Table(name = "administrator")
public class Administrator {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "first_name")
	@Size(max = 25, min = 3, message = "{Invalid first name}")
	@NotNull(message = "Please enter your first name")
	private String firstName;
	
	
	@Column(name = "last_name")
	@Size(max = 25, min = 3, message = "{Invalid last name}")
	@NotNull(message = "Please enter your last name")
	private String lastName;
	
	@Column(name = "email", unique = true)
	@Email(message = "{Invalid email}")
	@NotNull(message = "Please enter your email")
	private String email;
	
	@Column(name = "password")
	@NotNull(message = "Please provide a valid password")
	@Size(max = 70, min = 8, message = "Invalid password length")
	private String password;
	
	@Column(name = "role")
	private final String role = "admin";
	
	@Column(name = "contact_number")
	@NotNull(message = "Please enter a contact number")
	private long contactNumber;
	
	/**
	 * Default Constructor
	 */
	public Administrator() {
		
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the contactNumber
	 */
	public long getContactNumber() {
		return contactNumber;
	}

	/**
	 * @param contactNumber the contactNumber to set
	 */
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}
	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * Retrieve the password value
	 */
	public String getPassword() {
		
		
		return password;
	}

	/**
	 * Set the password value
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Administrator [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", role=" + role + ", contactNumber=" + contactNumber + "]";
	}


	/**
	 * toString method
	 */
	

}
