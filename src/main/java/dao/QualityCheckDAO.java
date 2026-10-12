package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.project.jobwork_production_management.HibernateUtil;

import entity.QualityCheck;

public class QualityCheckDAO {
	public QualityCheck save(QualityCheck qualityCheck) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(qualityCheck);
        transaction.commit();
        session.close();
        System.out.println("Quality Check saved!");
        return qualityCheck;
    }
	public QualityCheck getById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        QualityCheck qualityCheck =session.find(QualityCheck.class, id);
        session.close();
        return qualityCheck;
    }
    public void delete(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        QualityCheck qualityCheck =session.find(QualityCheck.class, id);
        session.remove(qualityCheck);
        transaction.commit();
        session.close();
        System.out.println("Quality Check deleted!");
    }
}
