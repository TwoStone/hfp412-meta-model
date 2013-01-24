package persistence;

import model.messageOrLink.*;

public class ActualParameterFacade{

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

	

	public ActualParameterFacade() {
	}

    public ActualParameterProxi newActualParameter(long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (ActualParameterProxi)PersistentProxi.createProxi(createMinusStorePlus, 194);
        long id = ConnectionHandler.getTheConnectionHandler().theActualParameterFacade.getNextId();
        ActualParameter result = new ActualParameter(null,null,null,id);
        Cache.getTheCache().put(result);
        return (ActualParameterProxi)PersistentProxi.createProxi(id, 194);
    }
    
    public ActualParameterProxi newDelayedActualParameter() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theActualParameterFacade.getNextId();
        ActualParameter result = new ActualParameter(null,null,null,id);
        Cache.getTheCache().put(result);
        return (ActualParameterProxi)PersistentProxi.createProxi(id, 194);
    }
    
    public ActualParameter getActualParameter(long ActualParameterId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 194)) return 194;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void typeSet(long ActualParameterId, PersistentFormalParameter typeVal) throws PersistenceException {
        
    }
    public void valueSet(long ActualParameterId, PersistentInstanceObject valueVal) throws PersistenceException {
        
    }
    public void ThisSet(long ActualParameterId, PersistentActualParameter ThisVal) throws PersistenceException {
        
    }

}
