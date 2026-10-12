package dao;
import org.hibernate.*;
import com.project.jobwork_production_management.*;
import entity.MaterialReceipt;
public class MaterialReceiptDAO {
	 public MaterialReceipt save(MaterialReceipt materialReceipt) {
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        Transaction transaction = session.beginTransaction();
	        session.persist(materialReceipt);
	        transaction.commit();
	        session.close();
	        System.out.println("Material Receipt saved!");
	        return materialReceipt;
	    }
	 public MaterialReceipt getById(Long id) {
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        MaterialReceipt materialReceipt =session.find(MaterialReceipt.class, id);
	        session.close();
	        return materialReceipt;
	    }
	    public void delete(Long id) {
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        Transaction transaction = session.beginTransaction();
	        MaterialReceipt materialReceipt =session.find(MaterialReceipt.class, id);
	        session.remove(materialReceipt);
	        transaction.commit();
	        session.close();
	        System.out.println("Material Receipt deleted!");
	    }
}
