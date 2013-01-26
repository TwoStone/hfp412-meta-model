package persistence;

import model.abstractOperation.*;

public class OperationManagerFacade{

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

	

	public OperationManagerFacade() {
	}

    public OperationManagerProxi getTheOperationManager() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theOperationManagerFacade.getNextId();
        OperationManager result = new OperationManager(null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (OperationManagerProxi)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().equals(result) ? -1 : 1), 121);
    }
    
    public OperationManager getOperationManager(long OperationManagerId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 121)) return 121;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public long operationsAdd(long OperationManagerId, PersistentOperation operationsVal) throws PersistenceException {
        return 0;
    }
    public void operationsRem(long operationsId) throws PersistenceException {
        
    }
    public OperationList operationsGet(long OperationManagerId) throws PersistenceException {
        return new OperationList(); // remote access for initialization only!
    }
    public long formalParametersAdd(long OperationManagerId, PersistentFormalParameter formalParametersVal) throws PersistenceException {
        return 0;
    }
    public void formalParametersRem(long formalParametersId) throws PersistenceException {
        
    }
    public FormalParameterList formalParametersGet(long OperationManagerId) throws PersistenceException {
        return new FormalParameterList(); // remote access for initialization only!
    }
    public void ThisSet(long OperationManagerId, PersistentOperationManager ThisVal) throws PersistenceException {
        
    }

}

