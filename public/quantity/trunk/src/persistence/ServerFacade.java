package persistence;

import model.*;

public class ServerFacade{

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

	

	public ServerFacade() {
	}

    public ServerProxi newServer(String password,String user,long hackCount,java.sql.Timestamp hackDelay,long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (ServerProxi)PersistentProxi.createProxi(createMinusStorePlus, -121);
        long id = ConnectionHandler.getTheConnectionHandler().theServerFacade.getNextId();
        Server result = new Server(null,password,user,hackCount,hackDelay,id);
        Cache.getTheCache().put(result);
        return (ServerProxi)PersistentProxi.createProxi(id, -121);
    }
    
    public ServerProxi newDelayedServer(String password,String user,long hackCount,java.sql.Timestamp hackDelay) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theServerFacade.getNextId();
        Server result = new Server(null,password,user,hackCount,hackDelay,id);
        Cache.getTheCache().put(result);
        return (ServerProxi)PersistentProxi.createProxi(id, -121);
    }
    
    public Server getServer(long ServerId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, -121)) return -121;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public ServerSearchList getServerByUser(String user) throws PersistenceException {
        ServerSearchList result = new ServerSearchList();
        java.util.Iterator<?> candidates;
        candidates = Cache.getTheCache().iterator(-121);
        while (candidates.hasNext()){
            PersistentServer current = (PersistentServer)((PersistentRoot)candidates.next()).getTheObject();
            if (current != null && !current.isDltd() && current.getUser().equals(user))
                result.add((PersistentServer)PersistentProxi.createProxi(current.getId(), current.getClassId()));
        }
        return result;
    }
    public void ThisSet(long ServerId, PersistentServer ThisVal) throws PersistenceException {
        
    }
    public void passwordSet(long ServerId, String passwordVal) throws PersistenceException {
        
    }
    public void userSet(long ServerId, String userVal) throws PersistenceException {
        
    }
    public void hackCountSet(long ServerId, long hackCountVal) throws PersistenceException {
        
    }
    public void hackDelaySet(long ServerId, java.sql.Timestamp hackDelayVal) throws PersistenceException {
        
    }

}

