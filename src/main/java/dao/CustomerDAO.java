package dao;

import org.hibernate.*;

import com.project.jobwork_production_management.*;
import entity.Customer;
public class CustomerDAO {
	public Customer save(Customer customer) {
		 Session session = HibernateUtil.getSessionFactory().openSession();
	        Transaction transaction = session.beginTransaction();
	        session.persist(customer);
	        transaction.commit();
	        session.close();
	        System.out.println("Customer saved!");
	        return customer;
	}
	public Customer getById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Customer customer = session.find(Customer.class, id);
        session.close();
        return customer;
    }
	public void update(Customer customer) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(customer);
        transaction.commit();
        session.close();
    }
    public void delete(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Customer customer = session.find(Customer.class, id);
        session.remove(customer);
        transaction.commit();
        session.close();
        System.out.println("Customer deleted!");
    }
}
