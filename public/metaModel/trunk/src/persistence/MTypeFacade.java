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
        if(Cache.getTheCache().contains(objectId, 185)) return 185;
        if(Cache.getTheCache().contains(objectId, 142)) return 142;
        if(Cache.getTheCache().contains(objectId, 107)) return 107;
        if(Cache.getTheCache().contains(objectId, 114)) return 114;
        if(Cache.getTheCache().contains(objectId, 134)) return 134;
        if(Cache.getTheCache().contains(objectId, 112)) return 112;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void ThisSet(long MTypeId, PersistentMType ThisVal) throws PersistenceException {
        
    }

}

