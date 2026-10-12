package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.project.jobwork_production_management.HibernateUtil;

import entity.Payment;

public class PaymentDAO {
	 public Payment save(Payment payment) {
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        Transaction transaction = session.beginTransaction();
	        session.persist(payment);
	        transaction.commit();
	        session.close();
	        System.out.println("Payment saved!");
	        return payment;
	    }
	 public Payment getById(Long id) {
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        Payment payment = session.find(Payment.class, id);
	        session.close();
	        return payment;
	    }
	    public void delete(Long id) {
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        Transaction transaction = session.beginTransaction();
	        Payment payment = session.find(Payment.class, id);
	        session.remove(payment);
	        transaction.commit();
	        session.close();
	        System.out.println("Payment deleted!");
	    }
}
