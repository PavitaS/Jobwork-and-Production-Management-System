package dao;
import org.hibernate.*;

import com.project.jobwork_production_management.*;
import entity.JobOrder;
public class JobOrderDAO {
	public JobOrder save(JobOrder jobOrder) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(jobOrder);
        transaction.commit();
        session.close();
        System.out.println("Job Order saved!");
        return jobOrder;
    }
	public JobOrder getById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        JobOrder jobOrder = session.find(JobOrder.class, id);
        session.close();
        return jobOrder;
    }
    public void delete(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        JobOrder jobOrder = session.find(JobOrder.class, id);
        session.remove(jobOrder);
        transaction.commit();
        session.close();
        System.out.println("Job Order deleted!");
    }
}
