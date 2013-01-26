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
        if(Cache.getTheCache().contains(objectId, 187)) return 187;
        if(Cache.getTheCache().contains(objectId, 144)) return 144;
        if(Cache.getTheCache().contains(objectId, 108)) return 108;
        if(Cache.getTheCache().contains(objectId, 115)) return 115;
        if(Cache.getTheCache().contains(objectId, 136)) return 136;
        if(Cache.getTheCache().contains(objectId, 113)) return 113;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void ThisSet(long MTypeId, PersistentMType ThisVal) throws PersistenceException {
        
    }

}

