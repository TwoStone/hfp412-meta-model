package persistence;

import model.*;

public class FunctionFacade{

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

	

	public FunctionFacade() {
	}

    public FunctionProxi newFunction() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theFunctionFacade.getNextId();
        Function result = new Function(null,id);
        Cache.getTheCache().put(result);
        return (FunctionProxi)PersistentProxi.createProxi(id, 107);
    }
    
    public Function getFunction(long FunctionId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 107)) return 107;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void ThisSet(long FunctionId, PersistentFunction ThisVal) throws PersistenceException {
        
    }

}

