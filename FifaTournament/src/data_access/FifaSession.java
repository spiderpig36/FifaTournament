package data_access;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FifaSession {

	private static SessionFactory fifaSessionFactory = null;

	private FifaSession() {

	}

	public static Session getSession() {
		if (fifaSessionFactory == null) {
			fifaSessionFactory = new Configuration().configure().buildSessionFactory();
		}
		return fifaSessionFactory.openSession();
	}
}
