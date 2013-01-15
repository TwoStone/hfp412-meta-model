package persistence;



public class QuantifObjectFacade{

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

	

	public QuantifObjectFacade() {
	}

    public long getClass(long objectId) throws PersistenceException{
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void defaultTypeSet(long QuantifObjectId, PersistentInstanceObject defaultTypeVal) throws PersistenceException {
        
    }
    public void ThisSet(long QuantifObjectId, PersistentQuantifObject ThisVal) throws PersistenceException {
        
    }

}

