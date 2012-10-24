package persistence;



public class AbsUnitFacade{

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

	

	public AbsUnitFacade() {
	}

    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 118)) return 118;
        if(Cache.getTheCache().contains(objectId, 119)) return 119;
        if(Cache.getTheCache().contains(objectId, 122)) return 122;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void nameSet(long AbsUnitId, String nameVal) throws PersistenceException {
        
    }
    public void ThisSet(long AbsUnitId, PersistentAbsUnit ThisVal) throws PersistenceException {
        
    }

}

