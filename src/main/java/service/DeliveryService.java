package service;

import dao.DeliveryDAO;
import entity.Delivery;

public class DeliveryService {
	 private DeliveryDAO deliveryDAO = new DeliveryDAO();
	 public Delivery saveDelivery(Delivery delivery) {
	        return deliveryDAO.save(delivery);
	    }
	 public Delivery getDelivery(Long id) {
	        return deliveryDAO.getById(id);
	    }
	 public void deleteDelivery(Long id) {
	        deliveryDAO.delete(id);
	    }
}
