package service;

import dao.JobOrderDAO;
import entity.JobOrder;

public class JobOrderService {
	private JobOrderDAO jobOrderDAO = new JobOrderDAO();
    public JobOrder saveJobOrder(JobOrder jobOrder) {
        return jobOrderDAO.save(jobOrder);
    }
    public JobOrder getJobOrder(Long id) {
        return jobOrderDAO.getById(id);
    }

    public void deleteJobOrder(Long id) {
        jobOrderDAO.delete(id);
    }
}
