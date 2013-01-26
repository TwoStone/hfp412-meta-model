package persistence;

import model.meta.*;

public class CommandExecuterFacade{

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

	

	public CommandExecuterFacade() {
	}

    public CommandExecuterProxi newCommandExecuter(long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (CommandExecuterProxi)PersistentProxi.createProxi(createMinusStorePlus, -193);
        long id = ConnectionHandler.getTheConnectionHandler().theCommandExecuterFacade.getNextId();
        CommandExecuter result = new CommandExecuter(id);
        Cache.getTheCache().put(result);
        return (CommandExecuterProxi)PersistentProxi.createProxi(id, -193);
    }
    
    public CommandExecuterProxi newDelayedCommandExecuter() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theCommandExecuterFacade.getNextId();
        CommandExecuter result = new CommandExecuter(id);
        Cache.getTheCache().put(result);
        return (CommandExecuterProxi)PersistentProxi.createProxi(id, -193);
    }
    
    public CommandExecuter getCommandExecuter(long CommandExecuterId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, -193)) return -193;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public long commandsAdd(long CommandExecuterId, Command commandsVal) throws PersistenceException {
        return 0;
    }
    public void commandsRem(long commandsId) throws PersistenceException {
        
    }
    public CommandList commandsGet(long CommandExecuterId) throws PersistenceException {
        return new CommandList(); // remote access for initialization only!
    }

}

