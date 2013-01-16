package persistence;

import model.measurement.*;

public class MeasurementFacade{



	public MeasurementFacade() {
	}

    public MeasurementProxi newMeasurement(long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (MeasurementProxi)PersistentProxi.createProxi(createMinusStorePlus, 195);
        long id = ConnectionHandler.getTheConnectionHandler().theQuantifObjectFacade.getNextId();
        Measurement result = new Measurement(null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (MeasurementProxi)PersistentProxi.createProxi(id, 195);
    }
    
    public MeasurementProxi newDelayedMeasurement() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theQuantifObjectFacade.getNextId();
        Measurement result = new Measurement(null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (MeasurementProxi)PersistentProxi.createProxi(id, 195);
    }
    
    public Measurement getMeasurement(long MeasurementId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public void typeSet(long MeasurementId, PersistentMMeasurementType typeVal) throws PersistenceException {
        
    }
    public void quantitySet(long MeasurementId, PersistentAbsQuantity quantityVal) throws PersistenceException {
        
    }

}

