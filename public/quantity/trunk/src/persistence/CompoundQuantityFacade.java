package persistence;

import model.*;

public class CompoundQuantityFacade{



	public CompoundQuantityFacade() {
	}

    public CompoundQuantityProxi newCompoundQuantity(long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (CompoundQuantityProxi)PersistentProxi.createProxi(createMinusStorePlus, 117);
        long id = ConnectionHandler.getTheConnectionHandler().theAbsQuantityFacade.getNextId();
        CompoundQuantity result = new CompoundQuantity(null,id);
        Cache.getTheCache().put(result);
        return (CompoundQuantityProxi)PersistentProxi.createProxi(id, 117);
    }
    
    public CompoundQuantityProxi newDelayedCompoundQuantity() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theAbsQuantityFacade.getNextId();
        CompoundQuantity result = new CompoundQuantity(null,id);
        Cache.getTheCache().put(result);
        return (CompoundQuantityProxi)PersistentProxi.createProxi(id, 117);
    }
    
    public CompoundQuantity getCompoundQuantity(long CompoundQuantityId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long partsAdd(long CompoundQuantityId, PersistentQuantity partsVal) throws PersistenceException {
        return 0;
    }
    public void partsRem(long partsId) throws PersistenceException {
        
    }
    public QuantityList partsGet(long CompoundQuantityId) throws PersistenceException {
        return new QuantityList(); // remote access for initialization only!
    }

}

