package com.JCatchpole.HotelBookingSystem.DAO;


import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.JCatchpole.HotelBookingSystem.model.Room;

/**
 * 
 * @author John Catchpole 23/03/2022
 * Data Access Object class to handle interactions with the database for Room Entities
 */

@Repository
public class RoomDaoImpl implements RoomDao {
	
	//Inject SessionFactory object
	@Autowired
	private SessionFactory sessionFactory;
	
	//Inject a room object
	@Autowired
	private Room room;

	//method to add a room to the room table in the database
	@Override
	public boolean addRoom(Room room) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		boolean completed = false;
		
		try {
			tx = session.beginTransaction();
			session.save(room);
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

	//Method to delete a room from room table in the database
	@Override
	public boolean deleteRoom(int number) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		boolean completed = false;
		
		try {
			tx = session.beginTransaction();
			room = (Room) session.get(Room.class, number);
			session.delete(room);
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

	//Method to get a list of all rooms in the room table in the database
	@Override
	public List<Room> getAllRooms() {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		List<Room> allRooms = null;
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Room> criteria = builder.createQuery(Room.class);
		
		try {
			tx = session.beginTransaction();
			criteria.from(Room.class);
			allRooms = session.createQuery(criteria).getResultList();
			tx.commit();
		}catch(Exception e) {
			if(tx != null) {
				tx.rollback();
				e.printStackTrace();
			}
		}finally {
			session.close();
		}
		return allRooms;
	}

	//Method to get a room's detail from the room table in the database
	@Override
	public Room getRoomDetails(int number) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			room = (Room) session.get(Room.class, number);
			tx.commit();
		}catch(Exception e) {
			if(tx != null) {
				tx.rollback();
				e.printStackTrace();
			}
		}finally {
			session.close();
		}
		return room;
	}
	
	

}
