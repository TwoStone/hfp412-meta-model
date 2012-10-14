package persistence;

import model.*;

public class SupplierFacade{



	public SupplierFacade() {
	}

    public SupplierProxi newSupplier() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theRoleFacade.getNextId();
        Supplier result = new Supplier(null,null,id);
        Cache.getTheCache().put(result);
        return (SupplierProxi)PersistentProxi.createProxi(id, 120);
    }
    
    public Supplier getSupplier(long SupplierId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long portfolioAdd(long SupplierId, PersistentProduct portfolioVal) throws PersistenceException {
        return 0;
    }
    public void portfolioRem(long portfolioId) throws PersistenceException {
        
    }
    public ProductList portfolioGet(long SupplierId) throws PersistenceException {
        return new ProductList(); // remote access for initialization only!
    }

}

