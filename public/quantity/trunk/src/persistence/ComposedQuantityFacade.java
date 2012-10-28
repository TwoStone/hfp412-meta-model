package persistence;

import model.*;

public class ComposedQuantityFacade{



	public ComposedQuantityFacade() {
	}

    public ComposedQuantityProxi newComposedQuantity() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theAbsQuantityFacade.getNextId();
        ComposedQuantity result = new ComposedQuantity(null,id);
        Cache.getTheCache().put(result);
        return (ComposedQuantityProxi)PersistentProxi.createProxi(id, 123);
    }
    
    public ComposedQuantity getComposedQuantity(long ComposedQuantityId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long partsAdd(long ComposedQuantityId, PersistentQuantity partsVal) throws PersistenceException {
        return 0;
    }
    public void partsRem(long partsId) throws PersistenceException {
        
    }
    public QuantityList partsGet(long ComposedQuantityId) throws PersistenceException {
        return new QuantityList(); // remote access for initialization only!
    }

}

