package persistence;

import model.quantity.*;

public class ReferenceFacade{

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

	

	public ReferenceFacade() {
	}

    public ReferenceProxi newReference(long exponent,long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (ReferenceProxi)PersistentProxi.createProxi(createMinusStorePlus, 180);
        long id = ConnectionHandler.getTheConnectionHandler().theReferenceFacade.getNextId();
        Reference result = new Reference(null,exponent,null,null,id);
        Cache.getTheCache().put(result);
        return (ReferenceProxi)PersistentProxi.createProxi(id, 180);
    }
    
    public ReferenceProxi newDelayedReference(long exponent) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theReferenceFacade.getNextId();
        Reference result = new Reference(null,exponent,null,null,id);
        Cache.getTheCache().put(result);
        return (ReferenceProxi)PersistentProxi.createProxi(id, 180);
    }
    
    public Reference getReference(long ReferenceId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 180)) return 180;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void typeSet(long ReferenceId, PersistentReferenceType typeVal) throws PersistenceException {
        
    }
    public void exponentSet(long ReferenceId, long exponentVal) throws PersistenceException {
        
    }
    public void refSet(long ReferenceId, PersistentUnit refVal) throws PersistenceException {
        
    }
    public void ThisSet(long ReferenceId, PersistentReference ThisVal) throws PersistenceException {
        
    }

}

