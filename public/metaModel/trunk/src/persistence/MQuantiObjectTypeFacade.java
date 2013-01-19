package persistence;



public class MQuantiObjectTypeFacade{

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

	

	public MQuantiObjectTypeFacade() {
	}

    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 164)) return 164;
        if(Cache.getTheCache().contains(objectId, 125)) return 125;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void typeSet(long MQuantiObjectTypeId, PersistentMType typeVal) throws PersistenceException {
        
    }
    public void unitTypeSet(long MQuantiObjectTypeId, PersistentAbsUnitType unitTypeVal) throws PersistenceException {
        
    }
    public void ThisSet(long MQuantiObjectTypeId, PersistentMQuantiObjectType ThisVal) throws PersistenceException {
        
    }

}

