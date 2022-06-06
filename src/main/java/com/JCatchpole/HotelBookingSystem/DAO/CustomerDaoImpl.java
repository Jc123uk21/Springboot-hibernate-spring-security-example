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
import com.JCatchpole.HotelBookingSystem.model.Customer;



/**
 * 
 * @author John Catchpole 23/03/2022
 * Data Access Object class to handle interactions with the database for Customer Entities
 */

@Repository
public class CustomerDaoImpl implements CustomerDao {

	//Inject SessionFactory object
	@Autowired
	private SessionFactory sessionFactory;
	
	//Inject Customer object
	@Autowired
	private Customer customer;
	
	//Method to add Customer to customer table in the database
	@Override
	public boolean addCustomer(Customer newCustomer) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		boolean completed = false;
		
		
		try {
			
			tx = session.beginTransaction();
			
			//Save Customer Object to customer table within the database
			session.save(newCustomer);
			
			
			//Add customer as a valid user into the spring security users table
			Query query = session.createQuery("INSERT INTO users (username, password, enabled) VALUES (?, ?, ?)");
			query.setParameter(1, newCustomer.getEmail());
			query.setParameter(2, newCustomer.getPassword());
			query.setParameter(3, 1);
			query.executeUpdate();
			
			//Add customer authority into spring security authorities table/
			Query query1 = session.createQuery("INSERT INTO authorities (username, authority) VALUES (?, ?)");
			query1.setParameter(1, newCustomer.getEmail());
			query1.setParameter(2, newCustomer.getRole());
			query1.executeUpdate();
			
			tx.commit();
			completed = true;
		}catch(Exception e){
			if(tx!= null) {
				tx.rollback();
				completed = false;
				e.printStackTrace();
			}
		}finally {
			session.close();
		}
		return completed;
	}

	
	//Method to delete a customer by email value from the customer table in the database
	@Override
	public boolean deleteCustomer(String email) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		boolean completed = false;
		try {
			tx = session.beginTransaction();
			customer = (Customer) session.get(Customer.class, email);
			session.delete(customer);
			
			tx.commit();
			completed = true;
		}catch(Exception e) {
			if(tx != null) {
				tx.rollback();
				completed = false;
				e.printStackTrace();
			}
			
		}finally {
			session.close();
		}
		return completed;
	}

	//Method to get customer details from the customer table in the database using the customer's email
	@Override
	public Customer getCustomerDetails(String email) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			customer = (Customer) session.createQuery("from Customer c where c.email =:user_email").setParameter("user_email", email).uniqueResult();
			tx.commit();
			
		}catch(Exception e){
			if(tx != null) {
				tx.rollback();
				e.printStackTrace();
			}
			
		}finally {
			session.close();
		}
		return customer;
	}

	//Method to get a list of all customers held within the customer table in the database
	@Override
	public List<Customer> getAllCustomers() {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		List<Customer> allCustomers = null;
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Customer> criteria = builder.createQuery(Customer.class);
		try {
			tx = session.beginTransaction();
			criteria.from(Customer.class);
			allCustomers = session.createQuery(criteria).getResultList();
			tx.commit();
		}catch(Exception e) {
			if(tx != null) {
				tx.rollback();
				e.printStackTrace();
			}
		}finally {
			session.close();
		}
		return allCustomers;
	}
}

