package persistence;

import model.*;

public class OrderFacade{

	static private Long sequencer = new Long(0);

	static protected long getTheNextId(){
		long result = -1;
		synchronized (sequencer) { 
			result = sequencer.longValue() + 1;
			sequencer = new Long(result);
		}
		return result;
	}

	protected long getNextId(){
		return getTheNextId();
	}

	

	public OrderFacade() {
	}

    public OrderProxi newOrder() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theOrderFacade.getNextId();
        Order result = new Order(null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (OrderProxi)PersistentProxi.createProxi(id, 107);
    }
    
    public Order getOrder(long OrderId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 107)) return 107;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void positionSet(long OrderId, PersistentPosition positionVal) throws PersistenceException {
        
    }
    public void customerSet(long OrderId, PersistentCustomer customerVal) throws PersistenceException {
        
    }
    public void contractorSet(long OrderId, PersistentSupplier contractorVal) throws PersistenceException {
        
    }
    public void ThisSet(long OrderId, PersistentOrder ThisVal) throws PersistenceException {
        
    }

}

