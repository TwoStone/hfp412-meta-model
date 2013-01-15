package persistence;



public class MTypeFacade{

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

	

	public MTypeFacade() {
	}

    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 190)) return 190;
        if(Cache.getTheCache().contains(objectId, 103)) return 103;
        if(Cache.getTheCache().contains(objectId, 186)) return 186;
        if(Cache.getTheCache().contains(objectId, 101)) return 101;
        if(Cache.getTheCache().contains(objectId, 192)) return 192;
        if(Cache.getTheCache().contains(objectId, 102)) return 102;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void ThisSet(long MTypeId, PersistentMType ThisVal) throws PersistenceException {
        
    }

}

