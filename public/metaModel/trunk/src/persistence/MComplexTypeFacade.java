package persistence;



public class MComplexTypeFacade{

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

	

	public MComplexTypeFacade() {
	}

    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 186)) return 186;
        if(Cache.getTheCache().contains(objectId, 101)) return 101;
        if(Cache.getTheCache().contains(objectId, 185)) return 185;
        if(Cache.getTheCache().contains(objectId, 103)) return 103;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public long containedTypesAdd(long MComplexTypeId, MType containedTypesVal) throws PersistenceException {
        return 0;
    }
    public void containedTypesRem(long containedTypesId) throws PersistenceException {
        
    }
    public MTypeList containedTypesGet(long MComplexTypeId) throws PersistenceException {
        return new MTypeList(); // remote access for initialization only!
    }
    public void ThisSet(long MComplexTypeId, PersistentMComplexType ThisVal) throws PersistenceException {
        
    }

}

