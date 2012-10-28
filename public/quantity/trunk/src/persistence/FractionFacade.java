package persistence;

import model.*;

public class FractionFacade{

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

	

	public FractionFacade() {
	}

    public FractionProxi newFraction(long enumerator,long denominator) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theFractionFacade.getNextId();
        Fraction result = new Fraction(enumerator,denominator,null,id);
        Cache.getTheCache().put(result);
        return (FractionProxi)PersistentProxi.createProxi(id, 111);
    }
    
    public Fraction getFraction(long FractionId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 111)) return 111;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void enumeratorSet(long FractionId, long enumeratorVal) throws PersistenceException {
        
    }
    public void denominatorSet(long FractionId, long denominatorVal) throws PersistenceException {
        
    }
    public void ThisSet(long FractionId, PersistentFraction ThisVal) throws PersistenceException {
        
    }

}

