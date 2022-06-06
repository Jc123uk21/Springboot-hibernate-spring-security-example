package com.JCatchpole.HotelBookingSystem.DAO;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.JCatchpole.HotelBookingSystem.model.Reservation;


/**
 * 
 * @author John Catchpole 23/03/2022
 * Data Access Object class to handle interactions with the database for Reservation Entities
 */

@Repository
public class ReservationDaoImpl implements ReservationDao {

	//Inject SessionFactory object
	@Autowired
	private SessionFactory sessionFactory;
	
	//Inject a reservation object
	@Autowired
	private Reservation reservation;
	
	
	//Method to add a reservation to the reservation table in the database
	@Override
	public boolean addReservation(Reservation reservation) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		boolean completed = false;
		
		try {
			tx = session.beginTransaction();
			session.save(reservation);
			tx.commit();
			completed = true;
			
		}catch(Exception e) {
			if(tx != null) {
				tx.rollback();
				e.printStackTrace();
			}
		}finally {
			session.close();
		}
		return completed;
	}

	//Method to delete a reservation from the reservation table in the database
	@Override
	public boolean deleteReservation(long resNumber) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		boolean completed = false;
		
		try {
			tx = session.beginTransaction();
			reservation = (Reservation) session.get(Reservation.class, resNumber);
			session.delete(reservation);
			tx.commit();
			completed = true;
		}catch(Exception e) {
			if(tx != null) {
				tx.rollback();
				e.printStackTrace();
			}
		}finally {
			session.close();
		}
		return completed;
	}

	//Method to get a list of all the reservations held in the reservation table in the database
	@Override
	public List<Reservation> getAllReservations() {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		List<Reservation> allReservations = null;
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Reservation> criteria = builder.createQuery(Reservation.class);
		
		try {
			tx = session.beginTransaction();
			criteria.from(Reservation.class);
			allReservations = session.createQuery(criteria).getResultList();
			tx.commit();
		}catch(Exception e) {
			if(tx != null) {
				tx.rollback();
				e.printStackTrace();
			}
		}finally {
			session.close();
		}
		return allReservations;
	}

	
	//Method to get a reservation's details held in the reservation table in the database
	@Override
	public Reservation getReservationDetails(long resNumber) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			reservation = (Reservation) session.get(Reservation.class, resNumber);
			tx.commit();
		}catch(Exception e) {
			if(tx != null) {
				tx.rollback();
				e.printStackTrace();
			}
		}finally {
			session.close();
		}
		return reservation;
	}
	
	//Get the total number of room a type reserved for a specified period
	@Override
	public int getAvailableRooms(String type, Date start, Date end){
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		int reservedForPeriod = 0;
		try {
			Query query = session.createQuery("from Reservation r where r.room.type =:aType and r.startDate between :aStart and :aEnd and r.endDate =: aEnd");
			query.setParameter("aType", type);
			query.setParameter("aSatrt", start);
			query.setParameter("aEnd", end);
			reservedForPeriod = query.getResultList().size();			
			tx = session.beginTransaction();
			tx.commit();
		}catch(Exception e){ 
			if(tx != null) {
				tx.rollback();
				e.printStackTrace();
			}
		}finally {
			session.close();
		}
		return reservedForPeriod;
	}
	
	//Retrieve all customer reservations from database
	@SuppressWarnings("unchecked")
	public List<Reservation> getCustomerBookings(String username){
		//Setup Session object
		Session session = sessionFactory.openSession();
		//Create Transaction object
		Transaction tx = null;
		//Create an array to hold found reservations
		List<Reservation> bookings = new ArrayList<Reservation>();
		//Create a persistent query to retrieve data
		Query query = session.createQuery("from Reservation r where r.customer.email =:email");
		//Set query Parameter
		query.setParameter("email", username);
		try {
			tx = session.beginTransaction();
			bookings = query.getResultList();		
			tx.commit();
		}catch(Exception e){
			if(tx != null) {
				tx.rollback();
				e.printStackTrace();
			}
		}finally {
			session.close();
		}
		return bookings;
	}
	
	//Get the total number of room a type reserved for a specified period
		@Override
		public int getAvailableRoomNumber(String type, Date start, Date end){
			Session session = sessionFactory.openSession();
			Transaction tx = null;
			int roomNumber = 0;
			try {
				Query query = session.createQuery("from Reservation r where r.room.type =:aType and r.startDate between :aStart and :aEnd and r.endDate =: aEnd");
				query.setParameter("aType", type);
				query.setParameter("aSatrt", start);
				query.setParameter("aEnd", end);
				roomNumber = query.getResultList().size();			
				tx = session.beginTransaction();
				tx.commit();
			}catch(Exception e){ 
				if(tx != null) {
					tx.rollback();
					e.printStackTrace();
				}
			}finally {
				session.close();
			}
			return roomNumber;
		}

}
