package persistence;

import model.typeSystem.*;

public class MAbstractProductTypeFacade{



	public MAbstractProductTypeFacade() {
	}

    public MAbstractProductTypeProxi newMAbstractProductType(long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (MAbstractProductTypeProxi)PersistentProxi.createProxi(createMinusStorePlus, 136);
        long id = ConnectionHandler.getTheConnectionHandler().theMTypeFacade.getNextId();
        MAbstractProductType result = new MAbstractProductType(null,id);
        Cache.getTheCache().put(result);
        return (MAbstractProductTypeProxi)PersistentProxi.createProxi(id, 136);
    }
    
    public MAbstractProductTypeProxi newDelayedMAbstractProductType() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theMTypeFacade.getNextId();
        MAbstractProductType result = new MAbstractProductType(null,id);
        Cache.getTheCache().put(result);
        return (MAbstractProductTypeProxi)PersistentProxi.createProxi(id, 136);
    }
    
    public MAbstractProductType getMAbstractProductType(long MAbstractProductTypeId) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

