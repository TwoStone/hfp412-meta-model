package persistence;



public class MessageOrLinkFacade{

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

	

	public MessageOrLinkFacade() {
	}

    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 198)) return 198;
        if(Cache.getTheCache().contains(objectId, 200)) return 200;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void sourceSet(long MessageOrLinkId, PersistentInstanceObject sourceVal) throws PersistenceException {
        
    }
    public void targetSet(long MessageOrLinkId, PersistentInstanceObject targetVal) throws PersistenceException {
        
    }
    public void ThisSet(long MessageOrLinkId, PersistentMessageOrLink ThisVal) throws PersistenceException {
        
    }

}

