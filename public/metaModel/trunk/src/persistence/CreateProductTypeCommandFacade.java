package persistence;

import model.meta.*;

public class CreateProductTypeCommandFacade{

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

	

	public CreateProductTypeCommandFacade() {
	}

    public CreateProductTypeCommandProxi newCreateProductTypeCommand(long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (CreateProductTypeCommandProxi)PersistentProxi.createProxi(createMinusStorePlus, 187);
        long id = ConnectionHandler.getTheConnectionHandler().theCreateProductTypeCommandFacade.getNextId();
        CreateProductTypeCommand result = new CreateProductTypeCommand(null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (CreateProductTypeCommandProxi)PersistentProxi.createProxi(id, 187);
    }
    
    public CreateProductTypeCommandProxi newDelayedCreateProductTypeCommand() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theCreateProductTypeCommandFacade.getNextId();
        CreateProductTypeCommand result = new CreateProductTypeCommand(null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (CreateProductTypeCommandProxi)PersistentProxi.createProxi(id, 187);
    }
    
    public CreateProductTypeCommand getCreateProductTypeCommand(long CreateProductTypeCommandId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 187)) return 187;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public long factorsAdd(long CreateProductTypeCommandId, PersistentMType factorsVal) throws PersistenceException {
        return 0;
    }
    public void factorsRem(long factorsId) throws PersistenceException {
        
    }
    public MTypeList factorsGet(long CreateProductTypeCommandId) throws PersistenceException {
        return new MTypeList(); // remote access for initialization only!
    }
    public void invokerSet(long CreateProductTypeCommandId, Invoker invokerVal) throws PersistenceException {
        
    }
    public void commandReceiverSet(long CreateProductTypeCommandId, PersistentTypeManager commandReceiverVal) throws PersistenceException {
        
    }
    public void commandResultSet(long CreateProductTypeCommandId, PersistentMAbstractProductType commandResultVal) throws PersistenceException {
        
    }
    public void myCommonDateSet(long CreateProductTypeCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        
    }

}

