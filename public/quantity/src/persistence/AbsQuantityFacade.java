package persistence;



public class AbsQuantityFacade{

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

	

	public AbsQuantityFacade() {
	}

    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 112)) return 112;
        if(Cache.getTheCache().contains(objectId, 123)) return 123;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void ThisSet(long AbsQuantityId, PersistentAbsQuantity ThisVal) throws PersistenceException {
        
    }

}

