package data_access;

import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Class that simplifies DataBase operations via Hibernate The user of the class
 * only needs knowledge of the HQL.
 * 
 * @author Nic
 *
 */
public class DataAccess {

	public static SimpleDateFormat hqlDateFormat = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * Reads data from the database
	 * 
	 * @param query
	 *            HQL Query that defines the read request
	 * @return A List of all data fetched from by the query
	 */
	public static List<?> read(String query) {
		Session session = FifaSession.getSession();
		List<?> list = session.createQuery(query).list();
		session.close();
		return list;
	}

	/**
	 * Saves an object in the database
	 * 
	 * @param object
	 *            The object to be saved, it needs to be a Hibernate Entity
	 */
	public static void save(Object object) {
		Session session = FifaSession.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(object);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	/**
	 * Modifies data on the database
	 * 
	 * @param query
	 *            HQL Query that modiefes the data
	 * @return number of rows affected. -1 if the update was unsucessful
	 */
	public static int update(String query) {
		Session session = FifaSession.getSession();
		Transaction tx = null;
		int affectedRows = -1;
		try {
			tx = session.beginTransaction();
			affectedRows = session.createQuery(query).executeUpdate();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return affectedRows;
	}
}
