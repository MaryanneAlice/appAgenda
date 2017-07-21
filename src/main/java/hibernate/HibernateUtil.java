package hibernate;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

@SuppressWarnings("serial")
public class HibernateUtil implements Serializable{
	
	public static HibernateUtil instance = null;
	public static SessionFactory sessionFactory;

  
	public HibernateUtil()  throws HibernateException, Exception{ 
	  try
		{
	  Configuration configuration = new Configuration();
	    
		configuration.configure("/hibernate.cfg.xml");
		sessionFactory = configuration.buildSessionFactory(new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry());
		
		} 
	  catch (Throwable ex) {
          System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
 }
   
	public static HibernateUtil openSessionFactory() throws HibernateException, Exception {	
		System.out.println("[DEBBUGING]["+HibernateUtil.class.getCanonicalName()+".openSession()]");
		if (instance == null) 
		{		
			System.out.println("[DEBBUGING]["+HibernateUtil.class.getCanonicalName()+".session ... openning]");
			instance = new HibernateUtil();
		}
		System.out.println("[DEBBUGING]["+HibernateUtil.class.getCanonicalName()+".session ... opened]");	

			return instance;
	}
	  
	public static Session getOpenSession() throws HibernateException, Exception {	
		System.out.println("[DEBBUGING]["+HibernateUtil.class.getCanonicalName()+".getOpenSession()]");
		System.out.println(sessionFactory == null);
		return sessionFactory.openSession();
	}
	

	public static Session getCurrentSession() throws HibernateException, Exception {
		System.out.println("[DEBBUGING-GETOPENSESSION]["+HibernateUtil.class.getCanonicalName()+".getOpenSession()]");
		return sessionFactory.getCurrentSession();
	}
	
	public static void  closeSession() throws HibernateException, Exception{
		if (sessionFactory != null)
		{
			sessionFactory.close();
		}
	}
	
}
