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

    public ProductProxi newProduct(String name) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theProductFacade.getNextId();
        Product result = new Product(name,null,id);
        Cache.getTheCache().put(result);
        return (ProductProxi)PersistentProxi.createProxi(id, 126);
    }
    
    public Product getProduct(long ProductId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 126)) return 126;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public ProductSearchList getProductByName(String name) throws PersistenceException {
        ProductSearchList result = new ProductSearchList();
        java.util.Iterator candidates;
        candidates = Cache.getTheCache().iterator(126);
        while (candidates.hasNext()){
            PersistentProduct current = (PersistentProduct)((PersistentRoot)candidates.next()).getTheObject();
            if (current != null && !current.isDltd() && current.getName().equals(name))
                result.add((PersistentProduct)PersistentProxi.createProxi(current.getId(), current.getClassId()));
        }
        return result;
    }
    public void nameSet(long ProductId, String nameVal) throws PersistenceException {
        
    }
    public void ThisSet(long ProductId, PersistentProduct ThisVal) throws PersistenceException {
        
    }

}

