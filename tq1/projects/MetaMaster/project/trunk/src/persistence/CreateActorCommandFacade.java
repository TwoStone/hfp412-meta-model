package persistence;

import model.meta.*;

public class CreateActorCommandFacade{

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

	

	public CreateActorCommandFacade() {
	}

    public CreateActorCommandProxi newCreateActorCommand(String name) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theCreateActorCommandFacade.getNextId();
        CreateActorCommand result = new CreateActorCommand(name,null,null,null,id);
        Cache.getTheCache().put(result);
        return (CreateActorCommandProxi)PersistentProxi.createProxi(id, 108);
    }
    
    public CreateActorCommand getCreateActorCommand(long CreateActorCommandId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 108)) return 108;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void nameSet(long CreateActorCommandId, String nameVal) throws PersistenceException {
        
    }
    public void invokerSet(long CreateActorCommandId, Invoker invokerVal) throws PersistenceException {
        
    }
    public void commandReceiverSet(long CreateActorCommandId, PersistentActorManager commandReceiverVal) throws PersistenceException {
        
    }
    public void myCommonDateSet(long CreateActorCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        
    }

}

