package service;

import dao.QualityCheckDAO;
import entity.QualityCheck;

public class QualityCheckService {
	 private QualityCheckDAO qualityCheckDAO = new QualityCheckDAO();
	    public QualityCheck saveQualityCheck(QualityCheck qualityCheck) {
	        return qualityCheckDAO.save(qualityCheck);
	    }
	    public QualityCheck getQualityCheck(Long id) {
	        return qualityCheckDAO.getById(id);
	    }
	    public void deleteQualityCheck(Long id) {
	        qualityCheckDAO.delete(id);
	    }
}
