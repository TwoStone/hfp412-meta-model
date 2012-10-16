package persistence;

import model.*;

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

    public ActorProxi newActor(String name) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theActorFacade.getNextId();
        Actor result = new Actor(name,null,id);
        Cache.getTheCache().put(result);
        return (ActorProxi)PersistentProxi.createProxi(id, 131);
    }
    
    public Actor getActor(long ActorId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 125)) return 125;
        if(Cache.getTheCache().contains(objectId, 129)) return 129;
        if(Cache.getTheCache().contains(objectId, 131)) return 131;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public ActorSearchList getActorByName(String name) throws PersistenceException {
        ActorSearchList result = new ActorSearchList();
        java.util.Iterator candidates;
        candidates = Cache.getTheCache().iterator(125);
        while (candidates.hasNext()){
            PersistentActor current = (PersistentActor)((PersistentRoot)candidates.next()).getTheObject();
            if (current != null && !current.isDltd() && current.getName().equals(name))
                result.add((PersistentActor)PersistentProxi.createProxi(current.getId(), current.getClassId()));
        }
        candidates = Cache.getTheCache().iterator(129);
        while (candidates.hasNext()){
            PersistentActor current = (PersistentActor)((PersistentRoot)candidates.next()).getTheObject();
            if (current != null && !current.isDltd() && current.getName().equals(name))
                result.add((PersistentActor)PersistentProxi.createProxi(current.getId(), current.getClassId()));
        }
        candidates = Cache.getTheCache().iterator(131);
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

