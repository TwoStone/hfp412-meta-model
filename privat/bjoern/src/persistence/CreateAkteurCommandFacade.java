package persistence;

import model.meta.*;

public class CreateAkteurCommandFacade{

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

	

	public CreateAkteurCommandFacade() {
	}

    public CreateAkteurCommandProxi newCreateAkteurCommand(String name) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theCreateAkteurCommandFacade.getNextId();
        CreateAkteurCommand result = new CreateAkteurCommand(name,null,null,null,id);
        Cache.getTheCache().put(result);
        return (CreateAkteurCommandProxi)PersistentProxi.createProxi(id, 113);
    }
    
    public CreateAkteurCommand getCreateAkteurCommand(long CreateAkteurCommandId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 113)) return 113;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void nameSet(long CreateAkteurCommandId, String nameVal) throws PersistenceException {
        
    }
    public void invokerSet(long CreateAkteurCommandId, Invoker invokerVal) throws PersistenceException {
        
    }
    public void commandReceiverSet(long CreateAkteurCommandId, PersistentAkteurManager commandReceiverVal) throws PersistenceException {
        
    }
    public void myCommonDateSet(long CreateAkteurCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        
    }

}

