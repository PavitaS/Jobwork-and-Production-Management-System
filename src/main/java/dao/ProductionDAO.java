package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.project.jobwork_production_management.HibernateUtil;

import entity.Production;

public class ProductionDAO {
	public Production save(Production production) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(production);
        transaction.commit();
        session.close();
        System.out.println("Production saved!");
        return production;
    }
	public Production getById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Production production =session.find(Production.class, id);
        session.close();
        return production;
	}
    public void delete(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Production production =session.find(Production.class, id);
        session.remove(production);
        transaction.commit();
        session.close();
        System.out.println("Production deleted!");
    }
}
