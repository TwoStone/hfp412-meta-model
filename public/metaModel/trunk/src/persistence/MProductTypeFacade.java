package persistence;

import model.*;

public class MProductTypeFacade{



	public MProductTypeFacade() {
	}

    public MProductTypeProxi newMProductType(long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (MProductTypeProxi)PersistentProxi.createProxi(createMinusStorePlus, 101);
        long id = ConnectionHandler.getTheConnectionHandler().theMComplexTypeFacade.getNextId();
        MProductType result = new MProductType(null,id);
        Cache.getTheCache().put(result);
        return (MProductTypeProxi)PersistentProxi.createProxi(id, 101);
    }
    
    public MProductTypeProxi newDelayedMProductType() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theMComplexTypeFacade.getNextId();
        MProductType result = new MProductType(null,id);
        Cache.getTheCache().put(result);
        return (MProductTypeProxi)PersistentProxi.createProxi(id, 101);
    }
    
    public MProductType getMProductType(long MProductTypeId) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

