/**
 * 
 */
package efs.thesis.common.util;

import org.hibernate.SessionFactory;

/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */

public class HibernateUtil {
	public static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		HibernateUtil.sessionFactory = sessionFactory;
	}
}
