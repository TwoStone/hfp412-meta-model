package persistence;

import model.*;

public class MOperationFacade{



	public MOperationFacade() {
	}

    public MOperationProxi newMOperation(String name,long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (MOperationProxi)PersistentProxi.createProxi(createMinusStorePlus, 197);
        long id = ConnectionHandler.getTheConnectionHandler().theMAbsOperationFacade.getNextId();
        MOperation result = new MOperation(name,null,null,null,id);
        Cache.getTheCache().put(result);
        return (MOperationProxi)PersistentProxi.createProxi(id, 197);
    }
    
    public MOperationProxi newDelayedMOperation(String name) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theMAbsOperationFacade.getNextId();
        MOperation result = new MOperation(name,null,null,null,id);
        Cache.getTheCache().put(result);
        return (MOperationProxi)PersistentProxi.createProxi(id, 197);
    }
    
    public MOperation getMOperation(long MOperationId) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

