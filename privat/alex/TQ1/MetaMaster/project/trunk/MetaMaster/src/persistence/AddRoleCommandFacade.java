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

    public AddRoleCommandProxi newAddRoleCommand(String roleName) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theAddRoleCommandFacade.getNextId();
        AddRoleCommand result = new AddRoleCommand(null,roleName,null,null,null,id);
        Cache.getTheCache().put(result);
        return (AddRoleCommandProxi)PersistentProxi.createProxi(id, 104);
    }
    
    public AddRoleCommand getAddRoleCommand(long AddRoleCommandId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 104)) return 104;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void actorSet(long AddRoleCommandId, PersistentActor actorVal) throws PersistenceException {
        
    }
    public void roleNameSet(long AddRoleCommandId, String roleNameVal) throws PersistenceException {
        
    }
    public void invokerSet(long AddRoleCommandId, Invoker invokerVal) throws PersistenceException {
        
    }
    public void commandReceiverSet(long AddRoleCommandId, PersistentActorManager commandReceiverVal) throws PersistenceException {
        
    }
    public void myCommonDateSet(long AddRoleCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        
    }

}

