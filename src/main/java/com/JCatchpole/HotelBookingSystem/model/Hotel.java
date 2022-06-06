package com.JCatchpole.HotelBookingSystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "hotel")
public class Hotel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "hotel_Id")
	private long id;
	
	@Column(name = "Name")
	@Size(max = 30, min = 3, message = "{Invalid Hotel Name}")
	@NotNull(message = "{Please enter a hotel name}")
	private String name;
	
	
	@Column(name = "Email", unique = true)
	@Email(message = "{hotel.email.invalid}")
	@NotNull(message = "Please enter hotel email")
	private String email;
	
	@Column(name = "contact_Number")
	@NotNull(message = "Please enter hotel contact number")
	private long contactNumber;
	
	@Column(name = "Address")
	@NotNull(message = "Please enter hotel address")
	@Size(max = 80, min = 10, message = "{Invalid hotel address}")
	private String address;
	
	@Column(name = "numberOfDoubleRooms")
	private int numberOfDoubleRooms;
	
	@Column(name= "numberOfKingSizeRooms")
	private int NumberOfKingSizeRooms;
	
	@Column(name = "numberOfFamilyRooms")
	private int numberOffamilyRooms;
	
	@Column(name = "numberOfSingleRooms")
	private int numberOfSingleRooms;
	
	/**
	 * Default Constructor
	 */
	public Hotel() {
		
	}
	
	

	/**
	 * @return the numberOfDoubleRooms
	 */
	public int getNumberOfDoubleRooms() {
		return numberOfDoubleRooms;
	}



	/**
	 * @param numberOfDoubleRooms the numberOfDoubleRooms to set
	 */
	public void setNumberOfDoubleRooms(int numberOfDoubleRooms) {
		this.numberOfDoubleRooms = numberOfDoubleRooms;
	}



	/**
	 * @return the numberOfKingSizeRooms
	 */
	public int getNumberOfKingSizeRooms() {
		return NumberOfKingSizeRooms;
	}



	/**
	 * @param numberOfKingSizeRooms the numberOfKingSizeRooms to set
	 */
	public void setNumberOfKingSizeRooms(int numberOfKingSizeRooms) {
		NumberOfKingSizeRooms = numberOfKingSizeRooms;
	}



	/**
	 * @return the numberOffamilyRooms
	 */
	public int getNumberOffamilyRooms() {
		return numberOffamilyRooms;
	}



	/**
	 * @param numberOffamilyRooms the numberOffamilyRooms to set
	 */
	public void setNumberOffamilyRooms(int numberOffamilyRooms) {
		this.numberOffamilyRooms = numberOffamilyRooms;
	}



	/**
	 * @return the numberOfSingleRooms
	 */
	public int getNumberOfSingleRooms() {
		return numberOfSingleRooms;
	}



	/**
	 * @param numberOfSingleRooms the numberOfSingleRooms to set
	 */
	public void setNumberOfSingleRooms(int numberOfSingleRooms) {
		this.numberOfSingleRooms = numberOfSingleRooms;
	}



	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @return the id
	 */
	public long getId() {
		return id;
	}



	@Override
	public String toString() {
		return "Hotel [id=" + id + ", name=" + name + ", email=" + email + ", contactNumber=" + contactNumber
				+ ", address=" + address + ", numberOfDoubleRooms=" + numberOfDoubleRooms + ", NumberOfKingSizeRooms="
				+ NumberOfKingSizeRooms + ", numberOffamilyRooms=" + numberOffamilyRooms + ", numberOfSingleRooms="
				+ numberOfSingleRooms + "]";
	}

	
	
	
	
}
