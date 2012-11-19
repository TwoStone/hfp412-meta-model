package persistence;

import model.*;

public class QuantityFacade{



	public QuantityFacade() {
	}

    public QuantityProxi newQuantity(common.Fraction amount,long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (QuantityProxi)PersistentProxi.createProxi(createMinusStorePlus, 116);
        long id = ConnectionHandler.getTheConnectionHandler().theAbsQuantityFacade.getNextId();
        Quantity result = new Quantity(null,amount,null,id);
        Cache.getTheCache().put(result);
        return (QuantityProxi)PersistentProxi.createProxi(id, 116);
    }
    
    public QuantityProxi newDelayedQuantity(common.Fraction amount) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theAbsQuantityFacade.getNextId();
        Quantity result = new Quantity(null,amount,null,id);
        Cache.getTheCache().put(result);
        return (QuantityProxi)PersistentProxi.createProxi(id, 116);
    }
    
    public Quantity getQuantity(long QuantityId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public void amountSet(long QuantityId, common.Fraction amountVal) throws PersistenceException {
        
    }
    public void unitSet(long QuantityId, PersistentUnit unitVal) throws PersistenceException {
        
    }

}

