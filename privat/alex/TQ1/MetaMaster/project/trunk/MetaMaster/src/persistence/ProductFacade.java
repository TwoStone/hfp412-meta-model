package persistence;

import model.*;

public class ProductFacade{

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

	

	public ProductFacade() {
	}

    public ProductProxi newProduct() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theProductFacade.getNextId();
        Product result = new Product(null,id);
        Cache.getTheCache().put(result);
        return (ProductProxi)PersistentProxi.createProxi(id, 115);
    }
    
    public Product getProduct(long ProductId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 115)) return 115;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void ThisSet(long ProductId, PersistentProduct ThisVal) throws PersistenceException {
        
    }

}

