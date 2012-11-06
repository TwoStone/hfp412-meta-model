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

    public FunctionProxi newFunction(common.Fraction factor,common.Fraction constant,long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (FunctionProxi)PersistentProxi.createProxi(createMinusStorePlus, 107);
        long id = ConnectionHandler.getTheConnectionHandler().theFunctionFacade.getNextId();
        Function result = new Function(factor,constant,null,id);
        Cache.getTheCache().put(result);
        return (FunctionProxi)PersistentProxi.createProxi(id, 107);
    }
    
    public FunctionProxi newDelayedFunction(common.Fraction factor,common.Fraction constant) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theFunctionFacade.getNextId();
        Function result = new Function(factor,constant,null,id);
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
    public void factorSet(long FunctionId, common.Fraction factorVal) throws PersistenceException {
        
    }
    public void constantSet(long FunctionId, common.Fraction constantVal) throws PersistenceException {
        
    }
    public void ThisSet(long FunctionId, PersistentFunction ThisVal) throws PersistenceException {
        
    }

}

