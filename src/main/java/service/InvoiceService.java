package service;

import dao.InvoiceDAO;
import entity.Invoice;

public class InvoiceService {
    private InvoiceDAO invoiceDAO = new InvoiceDAO();
    public Invoice saveInvoice(Invoice invoice) {
        return invoiceDAO.save(invoice);
    }
    public Invoice getInvoice(Long id) {
        return invoiceDAO.getById(id);
    }
    public void deleteInvoice(Long id) {
        invoiceDAO.delete(id);
    }
}
