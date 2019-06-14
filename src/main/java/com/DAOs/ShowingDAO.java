package com.DAOs;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.models.Showing;
import com.util.HibernateUtil;

public class ShowingDAO {
	
	// Create showing
	public Showing addShowing(Showing newShowing) {
		
		// Obtain SessionFactory
		try (SessionFactory factory = HibernateUtil.getSessionFactory();
				// Obtain a session
				Session session = factory.getCurrentSession()) {
			
			// Begin a transaction
			session.beginTransaction();
			
			// Add newShowing
			session.save(newShowing);
			
			// Commit the transaction
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Return the updated showing
		return newShowing;
		
	}
	
	// Get all showings
	public List<Showing> getAllShowing() {
		
		// Initialize a return variable
		List<Showing> allShowing = null;
		
		// Obtain SessionFactory
		try (SessionFactory factory = HibernateUtil.getSessionFactory();
				// Obtain a session
				Session session = factory.getCurrentSession()) {
		
			// Begin transaction
			session.beginTransaction();
			
			// Get the NamedQuery
			Query query = session.getNamedQuery("findAllShows");
		
			// Run query
			allShowing = query.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return allShowing;
		
	}
	
	// Get showing by id
	public List<Showing> getShowingById(Showing showing) {
		
		// Initialize a return variable
		List<Showing> allIdShowing = null;
		
		// Obtain SessionFactory
		try (SessionFactory factory = HibernateUtil.getSessionFactory();
				// Obtain a session
				Session session = factory.getCurrentSession()) {
			
			// Begin transaction
			session.beginTransaction();
			
			// Get the named query
			Query query = session.getNamedQuery("findShowById");
			query.setParameter("id", showing.getShowId());
			
			// Run the query
			allIdShowing = query.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Return the result
		return allIdShowing;
	}

}
