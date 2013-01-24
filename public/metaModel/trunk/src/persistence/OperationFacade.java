package persistence;

import model.abstractOperation.*;

public class OperationFacade{



	public OperationFacade() {
	}

    public OperationProxi newOperation(String name,long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (OperationProxi)PersistentProxi.createProxi(createMinusStorePlus, 146);
        long id = ConnectionHandler.getTheConnectionHandler().theAbsOperationFacade.getNextId();
        Operation result = new Operation(name,null,null,null,id);
        Cache.getTheCache().put(result);
        return (OperationProxi)PersistentProxi.createProxi(id, 146);
    }
    
    public OperationProxi newDelayedOperation(String name) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theAbsOperationFacade.getNextId();
        Operation result = new Operation(name,null,null,null,id);
        Cache.getTheCache().put(result);
        return (OperationProxi)PersistentProxi.createProxi(id, 146);
    }
    
    public Operation getOperation(long OperationId) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

