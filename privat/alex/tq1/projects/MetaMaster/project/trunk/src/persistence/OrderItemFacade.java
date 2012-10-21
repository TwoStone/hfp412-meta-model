package persistence;

import model.*;

public class OrderItemFacade{

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

	

	public OrderItemFacade() {
	}

    public OrderItemProxi newOrderItem(long quantity) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theOrderItemFacade.getNextId();
        OrderItem result = new OrderItem(quantity,null,null,id);
        Cache.getTheCache().put(result);
        return (OrderItemProxi)PersistentProxi.createProxi(id, 112);
    }
    
    public OrderItem getOrderItem(long OrderItemId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 112)) return 112;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void quantitySet(long OrderItemId, long quantityVal) throws PersistenceException {
        
    }
    public void productSet(long OrderItemId, PersistentProduct productVal) throws PersistenceException {
        
    }
    public void ThisSet(long OrderItemId, PersistentOrderItem ThisVal) throws PersistenceException {
        
    }

}

