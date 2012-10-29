package persistence;

import model.*;

public class ReferenceTypeFacade{

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

	

	public ReferenceTypeFacade() {
	}

    public ReferenceTypeProxi newReferenceType(long exponent) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theReferenceTypeFacade.getNextId();
        ReferenceType result = new ReferenceType(exponent,null,null,id);
        Cache.getTheCache().put(result);
        return (ReferenceTypeProxi)PersistentProxi.createProxi(id, 106);
    }
    
    public ReferenceType getReferenceType(long ReferenceTypeId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 106)) return 106;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void exponentSet(long ReferenceTypeId, long exponentVal) throws PersistenceException {
        
    }
    public void refSet(long ReferenceTypeId, PersistentUnitType refVal) throws PersistenceException {
        
    }
    public void ThisSet(long ReferenceTypeId, PersistentReferenceType ThisVal) throws PersistenceException {
        
    }

}

