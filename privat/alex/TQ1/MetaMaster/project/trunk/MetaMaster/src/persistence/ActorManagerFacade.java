package persistence;

import model.*;

public class ActorManagerFacade{

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

	

	public ActorManagerFacade() {
	}

    public ActorManagerProxi getTheActorManager() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theActorManagerFacade.getNextId();
        ActorManager result = new ActorManager(null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (ActorManagerProxi)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().equals(result) ? -1 : 1), 112);
    }
    
    public ActorManager getActorManager(long ActorManagerId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 112)) return 112;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public long actorsAdd(long ActorManagerId, PersistentActor actorsVal) throws PersistenceException {
        return 0;
    }
    public void actorsRem(long actorsId) throws PersistenceException {
        
    }
    public ActorList actorsGet(long ActorManagerId) throws PersistenceException {
        return new ActorList(); // remote access for initialization only!
    }
    public void ThisSet(long ActorManagerId, PersistentActorManager ThisVal) throws PersistenceException {
        
    }

}

