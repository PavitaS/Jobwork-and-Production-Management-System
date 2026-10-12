package service;

import dao.ProductionDAO;
import entity.Production;

public class ProductionService {
	private ProductionDAO productionDAO = new ProductionDAO();
    public Production saveProduction(Production production) {
        return productionDAO.save(production);
    }
    public Production getProduction(Long id) {
        return productionDAO.getById(id);
    }
    public void deleteProduction(Long id) {
        productionDAO.delete(id);
    }
}
