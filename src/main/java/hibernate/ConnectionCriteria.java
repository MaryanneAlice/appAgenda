package hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.gov.rn.parnamirim.model.ContatoModelo;

public class ConnectionCriteria {
	
	  public static void main(String[] args) throws HibernateException, Exception { 

		 Session session = HibernateUtil.openSessionFactory().getOpenSession();
		Transaction t = session.beginTransaction();
		ContatoModelo contato = new ContatoModelo();
		session.save(contato);
		t.commit();	
		session.close();
	  }
}
