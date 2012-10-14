package persistence;



public class ActorFacade{

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

	

	public ActorFacade() {
	}

    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 116)) return 116;
        if(Cache.getTheCache().contains(objectId, 119)) return 119;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public ActorSearchList getActorByName(String name) throws PersistenceException {
        ActorSearchList result = new ActorSearchList();
        java.util.Iterator candidates;
        candidates = Cache.getTheCache().iterator(116);
        while (candidates.hasNext()){
            PersistentActor current = (PersistentActor)((PersistentRoot)candidates.next()).getTheObject();
            if (current != null && !current.isDltd() && current.getName().equals(name))
                result.add((PersistentActor)PersistentProxi.createProxi(current.getId(), current.getClassId()));
        }
        candidates = Cache.getTheCache().iterator(119);
        while (candidates.hasNext()){
            PersistentActor current = (PersistentActor)((PersistentRoot)candidates.next()).getTheObject();
            if (current != null && !current.isDltd() && current.getName().equals(name))
                result.add((PersistentActor)PersistentProxi.createProxi(current.getId(), current.getClassId()));
        }
        return result;
    }
    public void nameSet(long ActorId, String nameVal) throws PersistenceException {
        
    }
    public void ThisSet(long ActorId, PersistentActor ThisVal) throws PersistenceException {
        
    }

}

