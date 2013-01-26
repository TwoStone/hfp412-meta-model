package persistence;

import model.meta.*;

public class CreateMeasurementTypeCommandFacade{

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

	

	public CreateMeasurementTypeCommandFacade() {
	}

    public CreateMeasurementTypeCommandProxi newCreateMeasurementTypeCommand(String name,long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (CreateMeasurementTypeCommandProxi)PersistentProxi.createProxi(createMinusStorePlus, 125);
        long id = ConnectionHandler.getTheConnectionHandler().theCreateMeasurementTypeCommandFacade.getNextId();
        CreateMeasurementTypeCommand result = new CreateMeasurementTypeCommand(name,null,null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (CreateMeasurementTypeCommandProxi)PersistentProxi.createProxi(id, 125);
    }
    
    public CreateMeasurementTypeCommandProxi newDelayedCreateMeasurementTypeCommand(String name) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theCreateMeasurementTypeCommandFacade.getNextId();
        CreateMeasurementTypeCommand result = new CreateMeasurementTypeCommand(name,null,null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (CreateMeasurementTypeCommandProxi)PersistentProxi.createProxi(id, 125);
    }
    
    public CreateMeasurementTypeCommand getCreateMeasurementTypeCommand(long CreateMeasurementTypeCommandId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 125)) return 125;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void nameSet(long CreateMeasurementTypeCommandId, String nameVal) throws PersistenceException {
        
    }
    public void typeSet(long CreateMeasurementTypeCommandId, PersistentMType typeVal) throws PersistenceException {
        
    }
    public void unitTypeSet(long CreateMeasurementTypeCommandId, PersistentUnitType unitTypeVal) throws PersistenceException {
        
    }
    public void invokerSet(long CreateMeasurementTypeCommandId, Invoker invokerVal) throws PersistenceException {
        
    }
    public void commandReceiverSet(long CreateMeasurementTypeCommandId, PersistentMeasurementTypeManager commandReceiverVal) throws PersistenceException {
        
    }
    public void myCommonDateSet(long CreateMeasurementTypeCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        
    }

}

