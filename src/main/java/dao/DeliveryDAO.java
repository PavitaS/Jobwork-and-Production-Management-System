package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.project.jobwork_production_management.HibernateUtil;

import entity.Delivery;

public class DeliveryDAO {
	public Delivery save(Delivery delivery) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(delivery);
        transaction.commit();
        session.close();
        System.out.println("Delivery saved!");
        return delivery;
    }
	 public Delivery getById(Long id) {
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        Delivery delivery = session.find(Delivery.class, id);
	        session.close();
	        return delivery;
	    }
	    public void delete(Long id) {
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        Transaction transaction = session.beginTransaction();
	        Delivery delivery = session.find(Delivery.class, id);
	        session.remove(delivery);
	        transaction.commit();
	        session.close();
	        System.out.println("Delivery deleted!");
	    }
}
