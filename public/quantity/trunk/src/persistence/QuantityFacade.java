package persistence;

import model.*;

public class QuantityFacade{



	public QuantityFacade() {
	}

    public QuantityProxi newQuantity() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theAbsQuantityFacade.getNextId();
        Quantity result = new Quantity(null,null,null,id);
        Cache.getTheCache().put(result);
        return (QuantityProxi)PersistentProxi.createProxi(id, 112);
    }
    
    public Quantity getQuantity(long QuantityId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public void amountSet(long QuantityId, PersistentFraction amountVal) throws PersistenceException {
        
    }
    public void unitSet(long QuantityId, PersistentUnit unitVal) throws PersistenceException {
        
    }

}

