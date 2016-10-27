package com.task07hibernate01.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.internal.StandardServiceRegistryImpl;
import org.hibernate.cfg.Configuration;

public class SessionConnection {

	private static SessionFactory sessionFactory;
	private static Session session;

	static {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		StandardServiceRegistryImpl registry = (StandardServiceRegistryImpl) builder.build();
		sessionFactory = configuration.buildSessionFactory(registry);
	}

	private SessionConnection() {
	}

	public static Session getSession() {
		return sessionFactory.openSession();
	}

	public static void closeSession() {
		if (session != null && session.isOpen()) {
			session.close();
		}
	}

	public static void closeSession(Session session) {
		if (session != null && session.isOpen()) {
			session.close();
		}
	}
}
