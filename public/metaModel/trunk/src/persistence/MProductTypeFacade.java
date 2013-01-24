package persistence;

import model.typeSystem.*;

public class MProductTypeFacade{



	public MProductTypeFacade() {
	}

    public MProductTypeProxi newMProductType(long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (MProductTypeProxi)PersistentProxi.createProxi(createMinusStorePlus, 114);
        long id = ConnectionHandler.getTheConnectionHandler().theMTypeFacade.getNextId();
        MProductType result = new MProductType(null,id);
        Cache.getTheCache().put(result);
        return (MProductTypeProxi)PersistentProxi.createProxi(id, 114);
    }
    
    public MProductTypeProxi newDelayedMProductType() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theMTypeFacade.getNextId();
        MProductType result = new MProductType(null,id);
        Cache.getTheCache().put(result);
        return (MProductTypeProxi)PersistentProxi.createProxi(id, 114);
    }
    
    public MProductType getMProductType(long MProductTypeId) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

