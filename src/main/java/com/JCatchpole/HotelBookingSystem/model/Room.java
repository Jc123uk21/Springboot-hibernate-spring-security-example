package com.JCatchpole.HotelBookingSystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "room")
public class Room {
	
	@Id
	@Column(name = "number")
	private int number;
	
	@Column(name = "max_capacity")
	@NotNull(message = "Please enter a maximum capacity")
	private int maxCapacity;
	
	@Column(name = "Description")
	@Size(max = 100, min = 6, message = "{Invalid description}")
	private String description;
	
	@Column(name = "Location")
	@Size(max = 25, min = 6, message = "{Invalid location}")
	@NotNull(message = "Please enter the rooms location")
	private String location;
	
	@Column(name = "room_Type")
	@NotNull(message = "please provide the room type value!")
	@Size(max = 10, min = 6, message = "Invalid room type provided")
	private String roomType;
	
	@Column(name = "rate")
	@NotNull(message ="Please provide the rate value")
	private double rate;
	
	/**
	 * Default Constructor
	 */
	public Room() {
		
	}
	

	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	
	
	
	/**
	 * Retrieve the rate value
	 */
	public double getRate() {
		return rate;
	}


	/**
	 * Set the rate value
	 */
	public void setRate() {
		
		//Set the room rate to the appropriate value depending on the room type
		if(this.getRoomType().equalsIgnoreCase("familyRoom")) {
			rate = 45;
		}
		else if(this.getRoomType().equalsIgnoreCase("kingSize")) {
			rate = 40;
		}
		else if(this.getRoomType().equalsIgnoreCase("double")) {
			rate = 35;
		}
		else if(this.getRoomType().equalsIgnoreCase("single")) {
			rate = 30;
		}
			
	}


	/**
	 * Retrieve the roomType
	 */
	public String getRoomType() {
		return roomType;
	}


	/**
	 * Set the the roomType value
	 */
	public void setRoomType(String roomType) {
	
		this.roomType = roomType;
	}


	/**
	 * @return the maxCapacity
	 */
	public int getMaxCapacity() {
		return maxCapacity;
	}

	/**
	 * @param maxCapacity the maxCapacity to set
	 */
	public void setMaxCapacity() {
		
		//Set the room maxCapacity to the appropriate value depending on the room type
				if(this.getRoomType().equalsIgnoreCase("familyRoom")) {
					this.maxCapacity = 5;
				}
				else if(this.getRoomType().equalsIgnoreCase("kingSize")) {
					this.maxCapacity = 3;
				}
				else if(this.getRoomType().equalsIgnoreCase("double")) {
					this.maxCapacity = 2;
				}
				else if(this.getRoomType().equalsIgnoreCase("single")) {
					this.maxCapacity = 1;
				}
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}


	/**
	 * toString
	 */
	@Override
	public String toString() {
		return "Room [number=" + number + ", maxCapacity=" + maxCapacity + ", description=" + description
				+ ", location=" + location + ", roomType=" + roomType + ", rate=" + rate + "]";
	}
	
	
	

}
