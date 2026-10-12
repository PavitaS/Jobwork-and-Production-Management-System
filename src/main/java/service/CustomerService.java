package service;

import dao.CustomerDAO;
import entity.Customer;

public class CustomerService {
	private CustomerDAO customerDAO = new CustomerDAO();
    public Customer saveCustomer(Customer customer) {
        return customerDAO.save(customer);
    }
    public Customer getCustomer(Long id) {
        return customerDAO.getById(id);
    }
    public void updateCustomer(Customer customer) {
        customerDAO.update(customer);
    }
    public void deleteCustomer(Long id) {
        customerDAO.delete(id);
    }
}
