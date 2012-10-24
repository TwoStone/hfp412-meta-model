package persistence;



public class AbsUnitTypeFacade{

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

	

	public AbsUnitTypeFacade() {
	}

    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 113)) return 113;
        if(Cache.getTheCache().contains(objectId, 114)) return 114;
        if(Cache.getTheCache().contains(objectId, 117)) return 117;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void ThisSet(long AbsUnitTypeId, PersistentAbsUnitType ThisVal) throws PersistenceException {
        
    }

}

