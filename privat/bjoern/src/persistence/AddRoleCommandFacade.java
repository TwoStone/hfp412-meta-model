package persistence;

import model.meta.*;

public class AddRoleCommandFacade{

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

	

	public AddRoleCommandFacade() {
	}

    public AddRoleCommandProxi newAddRoleCommand(String rollenName) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theAddRoleCommandFacade.getNextId();
        AddRoleCommand result = new AddRoleCommand(null,rollenName,null,null,null,id);
        Cache.getTheCache().put(result);
        return (AddRoleCommandProxi)PersistentProxi.createProxi(id, 120);
    }
    
    public AddRoleCommand getAddRoleCommand(long AddRoleCommandId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 120)) return 120;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void akteurSet(long AddRoleCommandId, PersistentAkteur akteurVal) throws PersistenceException {
        
    }
    public void rollenNameSet(long AddRoleCommandId, String rollenNameVal) throws PersistenceException {
        
    }
    public void invokerSet(long AddRoleCommandId, Invoker invokerVal) throws PersistenceException {
        
    }
    public void commandReceiverSet(long AddRoleCommandId, PersistentTransactionManager commandReceiverVal) throws PersistenceException {
        
    }
    public void myCommonDateSet(long AddRoleCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        
    }

}

