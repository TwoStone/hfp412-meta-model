package persistence;

import model.measurement.*;

public class MeasurementFacade{

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

	

	public MeasurementFacade() {
	}

    public MeasurementProxi newMeasurement(long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (MeasurementProxi)PersistentProxi.createProxi(createMinusStorePlus, 195);
        long id = ConnectionHandler.getTheConnectionHandler().theMeasurementFacade.getNextId();
        Measurement result = new Measurement(null,null,null,id);
        Cache.getTheCache().put(result);
        return (MeasurementProxi)PersistentProxi.createProxi(id, 195);
    }
    
    public MeasurementProxi newDelayedMeasurement() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theMeasurementFacade.getNextId();
        Measurement result = new Measurement(null,null,null,id);
        Cache.getTheCache().put(result);
        return (MeasurementProxi)PersistentProxi.createProxi(id, 195);
    }
    
    public Measurement getMeasurement(long MeasurementId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 195)) return 195;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void typeSet(long MeasurementId, PersistentMMeasurementType typeVal) throws PersistenceException {
        
    }
    public void quantitySet(long MeasurementId, PersistentAbsQuantity quantityVal) throws PersistenceException {
        
    }
    public void ThisSet(long MeasurementId, PersistentMeasurement ThisVal) throws PersistenceException {
        
    }

}

