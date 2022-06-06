package com.JCatchpole.HotelBookingSystem.model;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name = "reservation")
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "reservation_number", unique = true)
	private long reservationNumber;
	
	@Column(name = "start_Date")
	@NotNull(message = "Please enter a start date for stay")
	@DateTimeFormat(pattern = "dd.MM.yyyy")
	private Date startDate;
	
	@Column(name = "end_date")
	@NotNull(message = "Please enter a end date for stay")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date endDate;
	
	
	@JoinColumn(name = "customer")
	@OneToOne(cascade = {CascadeType.ALL})
	private Customer customer;
	
	@Column(name = "checked_in")
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime checkedIn;
	
	@Column(name = "checked_out")
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime checkedOut;
	
	@Column(name = "total_Cost")
	private double totalCost;
	
	@JoinColumn(name = "room")
	@OneToOne(cascade = {CascadeType.ALL})
	private Room room;
	
	/**
	 * Default Constructor
	 */
	public Reservation() {
		room = new Room();
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer aCustomer) {
		this.customer = aCustomer;
	}

	/**
	 * @return the checkedIn
	 */
	public LocalDateTime getCheckedIn() {
		return checkedIn;
	}

	/**
	 * @param checkedIn the checkedIn to set
	 */
	public void setCheckedIn(LocalDateTime checkedIn) {
		this.checkedIn = checkedIn;
	}

	/**
	 * @return the checkedOut
	 */
	public LocalDateTime getCheckedOut() {
		return checkedOut;
	}

	/**
	 * @param checkedOut the checkedOut to set
	 */
	public void setCheckedOut(LocalDateTime checkedOut) {
		this.checkedOut = checkedOut;
	}

	/**
	 * @return the totalCost
	 */
	public double getTotalCost() {
		return totalCost;
	}

	/**
	 * @param totalCost the totalCost to set
	 */
	public void setTotalCost() {
		
		//variable to hold the number of days between each date
		long numOfDays = ChronoUnit.DAYS.between(startDate.toLocalDate(), endDate.toLocalDate());
		
		//calculate the total cost of stay
		totalCost = this.getRoom().getRate() * Long.valueOf(numOfDays).intValue();
		
	}

	/**
	 * @return the room
	 */
	public Room getRoom() {
		return room;
	}

	/**
	 * @param room the room to set
	 */
	public void setRoom(Room room) {
		this.room = room;
	}

	/**
	 * @return the reservationNumber
	 */
	public long getReservationNumber() {
		return reservationNumber;
	}
	
	/**
	 * set the room type
	 */
	public void setRoomType(String roomType) {
		room.setRoomType(roomType);
	}
	
	/**
	 * get room type
	 */
	public String getRoomType() {
		return room.getRoomType();
	}
	

	@Override
	public String toString() {
		return "Reservation [reservationNumber=" + reservationNumber + ", startDate=" + startDate + ", endDate="
				+ endDate + ", customer=" + customer + ", checkedIn=" + checkedIn + ", checkedOut=" + checkedOut
				+ ", totalCost=" + totalCost + ", room=" + room + "]";
	}

	

	

}
