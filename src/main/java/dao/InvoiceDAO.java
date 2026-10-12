package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.project.jobwork_production_management.HibernateUtil;

import entity.Invoice;

public class InvoiceDAO {
	 public Invoice save(Invoice invoice) {
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        Transaction transaction = session.beginTransaction();
	        session.persist(invoice);
	        transaction.commit();
	        session.close();
	        System.out.println("Invoice saved!");
	        return invoice;
	    }
	 public Invoice getById(Long id) {
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        Invoice invoice = session.find(Invoice.class, id);
	        session.close();
	        return invoice;
	    }
	    public void delete(Long id) {
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        Transaction transaction = session.beginTransaction();
	        Invoice invoice = session.find(Invoice.class, id);
	        session.remove(invoice);
	        transaction.commit();
	        session.close();
	        System.out.println("Invoice deleted!");
	    }
}
