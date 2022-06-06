package com.JCatchpole.HotelBookingSystem.DAO;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.JCatchpole.HotelBookingSystem.model.Hotel;

/**
 * 
 * @author John Catchpole 23/03/2022
 * Data Access Object class to handle interactions with the database for Hotel Entities
 */


@Repository
public class HotelDaoImpl implements HotelDao {
	
	//Inject SessionFactory object
	@Autowired
	private SessionFactory sessionFactory;
	
	//Inject a hotel object 
	@Autowired
	private Hotel hotel;

	//Method to add a hotel to the hotel table in the database
	@Override
	public boolean addHotel(Hotel hotel) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		boolean completed = false;
		
		try {
			tx = session.beginTransaction();
			session.save(hotel);
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

	//Method to delete a hotel from the hotel table in the database
	@Override
	public boolean deleteHotel(String email) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		boolean completed = false;
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery("delete Hotel h where h.email =: hotel_email").setParameter("hotel_email", email);
			query.executeUpdate();
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

	//Method to get a list of all hotels in the hotel table in the database
	@Override
	public List<Hotel> getAllHotels() {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		List<Hotel> allHotels = null;
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Hotel> criteria = builder.createQuery(Hotel.class);
		
		try {
			tx = session.beginTransaction();
			criteria.from(Hotel.class);
			allHotels = session.createQuery(criteria).getResultList();
			tx.commit();
		}catch(Exception e) {
			if(tx != null) {
				tx.rollback();
				e.printStackTrace();
			}
		}finally {
			session.close();
		}
		return allHotels;
	}

	//Method to get a hotel details from the hotel table in the database
	@Override
	public Hotel getHotelDetails(String email) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			hotel = (Hotel) session.createQuery("from Hotel h where h.email =:hotel_email").setParameter("hotel_email", email).uniqueResult();
			tx.commit();
		}catch(Exception e) {
			if(tx != null) {
				tx.rollback();
				e.printStackTrace();
			}
		}finally {
			session.close();
		}
		return hotel;
	}

}
