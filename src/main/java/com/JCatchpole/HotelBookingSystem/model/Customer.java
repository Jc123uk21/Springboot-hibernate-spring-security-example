package com.JCatchpole.HotelBookingSystem.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;


@Entity
@Table(name = "customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private long id;
	
	@Column(name = "first_name")
	@Size(max = 50, min = 2, message = "{Invalid first Name}")
	@NotNull(message = "Please enter your first name")
	private String firstName;
	
	@Column(name = "last_name")
	@Size(max = 50, min = 3, message = "{Invalid last name}")
	@NotNull(message = "Please enter your last name")
	private String lastName;
	
	@Column(name = "address")
	@Size(max = 80, min = 15, message = "{Invlaid address}")
	@NotNull(message = "Please enter your address")
	private String address;
	
	@Column(name = "email", unique = true)
	@Email(message = "{customer.email.invalid}")
	@NotNull(message = "Please enter your email address")
	private String email;
	
	@Column(name = "contact_number")
	@NotNull(message = "Please enter a contact number")
	private String contactNumber;
	
	@Column(name = "password")
	@NotNull(message = "Please provide a password")
	@Size(max = 70, min = 8, message = "Invalid password length")
	private String password;
	
	@Column(name = "role")
	private final String role = "user";
	
	/**
	 * Retrieve password value
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Set password value
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Default Constructor
	 */
	public Customer() {
	
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
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
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
	public String getContactNumber() {
		return contactNumber;
	}

	/**
	 * @param contactNumber the contactNumber to set
	 */
	public void setContactNumber(String contactNumber) {
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
	 * toString
	 */

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
				+ ", email=" + email + ", contactNumber=" + contactNumber + ", password=" + password + ", role=" + role
				+ "]";
	}

	

	
	
	
	

}
