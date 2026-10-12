package service;

import dao.PaymentDAO;
import entity.Payment;

public class PaymentService {

    private PaymentDAO paymentDAO = new PaymentDAO();
    public Payment savePayment(Payment payment) {
        return paymentDAO.save(payment);
    }
    public Payment getPayment(Long id) {
        return paymentDAO.getById(id);
    }
    public void deletePayment(Long id) {
        paymentDAO.delete(id);
    }
}
