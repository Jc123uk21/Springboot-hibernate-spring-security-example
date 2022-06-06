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

import com.JCatchpole.HotelBookingSystem.model.Administrator;

/**
 * 
 * @author John Catchpole 23/03/2022
 * Data Access Object class to handle interactions with the database for Administrator Entities
 */

@Repository
public class AdminstratorDaoImpl implements AdministratorDao {
	
	//Inject SessionFactory object
	@Autowired
	private SessionFactory sessionFactory;
	
	//Inject Administrator object
	@Autowired
	private Administrator administrator;

	//Method to add administrator to the administrator table in the database
	@Override
	public boolean addAdministrator(Administrator admin) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		boolean completed = false;
		try {
			tx = session.beginTransaction();
			//Save administrator object into administrator table
			session.save(admin);
			
			//Add administrator as a valid user into the spring security users table
			Query query = session.createQuery("INSERT INTO users (username, password, enabled) VALUES (?, ?, ?)");
			query.setParameter(1, admin.getEmail());
			query.setParameter(2, admin.getPassword());
			query.setParameter(3, 1);
			query.executeUpdate();
			
			//Add administrator authority into spring security authorities table/
			Query query1 = session.createQuery("INSERT INTO authorities (username, authority) VALUES (?, ?)");
			query1.setParameter(1, admin.getEmail());
			query1.setParameter(2, admin.getRole());
			query1.executeUpdate();
			 
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
	
	//Method to update an administrators details
	@Override
	public boolean updateAdminDetails(Administrator admin) {
		boolean updated = false;
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			deleteAdminUser(admin.getEmail());
			session.save(admin);
			tx.commit();
			updated = true;
		}catch(Exception e) {
			if(tx != null) {
				tx.rollback();
				e.printStackTrace();
			}
		}finally {
			session.close();
		}
		return updated;
		
	}

	//Method to delete a administrator from the administrator table in the database
	@Override
	public boolean deleteAdminUser(String email) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		boolean completed = false;
		
		//Setup a Query to delete administrator by email from the administrator table
		String hql1 = "DELETE FROM administrator WHERE email = :admin_email";
		Query query1 = session.createQuery(hql1);
		query1.setParameter("admin_email", email);
		
		//Setup a Query to delete administrator from the security authority table
		String hql2 = "DELETE FROM authorities WHERE username = :admin_email";
		Query query2 = session.createQuery(hql2);
		query2.setParameter("admin_email", email);
		
		//Setup Query to delete administrator from the security users table
		String hql3 = "DELETE FROM users WHERE username = :admin_email";
		Query query3 = session.createQuery(hql3);
		query3.setParameter("admin_email", email);
		
	
		
		try {
			tx = session.beginTransaction();
			query2.executeUpdate();
			query3.executeUpdate();
			query1.executeUpdate();
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

	//Method to retrieve a list of all the administrator users held within the administrator table in the database
	@Override
	public List<Administrator> getAllAdminUsers() {
		
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		List<Administrator> allAdministrators = null;
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Administrator> criteria = builder.createQuery(Administrator.class);
		
		try {
			tx = session.beginTransaction();
			criteria.from(Administrator.class);
			allAdministrators = session.createQuery(criteria).getResultList();
			tx.commit();
		}catch(Exception e){
			if(tx != null) {
				tx.rollback();
				e.printStackTrace();
			}	
		}finally {
			session.close();
		}
		return allAdministrators;
		
	}

	//Method to retrieve the details of an individual administrator
	@Override
	public Administrator getAdminUsersDetails(String email) {
		
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			administrator = (Administrator) session.createQuery("from Administrator a where a.email =:anEmail").setParameter("anEmail", email)
					.uniqueResult();
			tx.commit();	
		}catch(Exception e) {
			if(tx != null) {
				tx.rollback();
				e.printStackTrace();
			}
			
		}finally {
			session.close();
		}
		
		return administrator;
	}

}
