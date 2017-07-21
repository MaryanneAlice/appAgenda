package model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.ui.Model;

import  hibernate.HibernateUtil;
import  services.ContatoService;

public class BancoContatos {
	
	private static List<ContatoModelo> contatos = new ArrayList<>();
	
	public static ContatoModelo buscarContato(Integer id) throws HibernateException, Exception {
		HibernateUtil.openSessionFactory();
		Session session = HibernateUtil.getOpenSession();
		Transaction t = session.beginTransaction();
		ContatoModelo contato = (ContatoModelo) session.createQuery("from ContatoModelo where id_user='"+id+"'").uniqueResult();
		t.commit();
		System.out.println(contato);
			return contato;
	}
	
	public  ContatoModelo addContato(ContatoModelo contato) throws HibernateException, Exception {
		HibernateUtil.openSessionFactory();
		Session session = HibernateUtil.getOpenSession();
		Transaction t = session.beginTransaction();
		System.out.println(contato.getId());
		session.update(contato);
		t.commit();
		session.close();
			return contato;
	}
	
	@SuppressWarnings("unchecked")
	public static List<ContatoModelo> listarContato() throws HibernateException, Exception { 
		HibernateUtil.openSessionFactory();
		Session session = HibernateUtil.getOpenSession();
		contatos = session.createQuery("from ContatoModelo").list();
			return contatos;
	}
	
	@SuppressWarnings("unchecked")
	public static List<ContatoModelo> deletarContato(Integer id) throws HibernateException, Exception {
		HibernateUtil.openSessionFactory();
		Session session = HibernateUtil.getOpenSession();
		Transaction t = session.beginTransaction();
		ContatoModelo contatoDel = (ContatoModelo) session.createQuery("from ContatoModelo where id_user='"+id+"'").uniqueResult();
		session.delete(contatoDel);
		t.commit();
		session.close();
			return contatos;
	}

}