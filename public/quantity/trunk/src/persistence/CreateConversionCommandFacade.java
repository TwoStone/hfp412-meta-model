package persistence;

import model.meta.*;

public class CreateConversionCommandFacade{

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

	

	public CreateConversionCommandFacade() {
	}

    public CreateConversionCommandProxi newCreateConversionCommand(common.Fraction factor,common.Fraction constant,long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (CreateConversionCommandProxi)PersistentProxi.createProxi(createMinusStorePlus, 130);
        long id = ConnectionHandler.getTheConnectionHandler().theCreateConversionCommandFacade.getNextId();
        CreateConversionCommand result = new CreateConversionCommand(null,factor,constant,null,null,null,id);
        Cache.getTheCache().put(result);
        return (CreateConversionCommandProxi)PersistentProxi.createProxi(id, 130);
    }
    
    public CreateConversionCommandProxi newDelayedCreateConversionCommand(common.Fraction factor,common.Fraction constant) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theCreateConversionCommandFacade.getNextId();
        CreateConversionCommand result = new CreateConversionCommand(null,factor,constant,null,null,null,id);
        Cache.getTheCache().put(result);
        return (CreateConversionCommandProxi)PersistentProxi.createProxi(id, 130);
    }
    
    public CreateConversionCommand getCreateConversionCommand(long CreateConversionCommandId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 130)) return 130;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void unitSet(long CreateConversionCommandId, PersistentUnit unitVal) throws PersistenceException {
        
    }
    public void factorSet(long CreateConversionCommandId, common.Fraction factorVal) throws PersistenceException {
        
    }
    public void constantSet(long CreateConversionCommandId, common.Fraction constantVal) throws PersistenceException {
        
    }
    public void invokerSet(long CreateConversionCommandId, Invoker invokerVal) throws PersistenceException {
        
    }
    public void commandReceiverSet(long CreateConversionCommandId, PersistentConversionManager commandReceiverVal) throws PersistenceException {
        
    }
    public void myCommonDateSet(long CreateConversionCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        
    }

}

