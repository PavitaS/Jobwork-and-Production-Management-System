package service;

import dao.MaterialReceiptDAO;
import entity.MaterialReceipt;

public class MaterialReceiptService {
	private MaterialReceiptDAO materialReceiptDAO = new MaterialReceiptDAO();
    public MaterialReceipt saveMaterialReceipt(MaterialReceipt materialReceipt) {
        return materialReceiptDAO.save(materialReceipt);
    }
    public MaterialReceipt getMaterialReceipt(Long id) {
        return materialReceiptDAO.getById(id);
    }
    public void deleteMaterialReceipt(Long id) {
        materialReceiptDAO.delete(id);
    }
}
