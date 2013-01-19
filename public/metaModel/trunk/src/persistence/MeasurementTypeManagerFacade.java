package persistence;

import model.measurement.*;

public class MeasurementTypeManagerFacade{

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

	

	public MeasurementTypeManagerFacade() {
	}

    public MeasurementTypeManagerProxi getTheMeasurementTypeManager() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theMeasurementTypeManagerFacade.getNextId();
        MeasurementTypeManager result = new MeasurementTypeManager(null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (MeasurementTypeManagerProxi)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().equals(result) ? -1 : 1), 184);
    }
    
    public MeasurementTypeManager getMeasurementTypeManager(long MeasurementTypeManagerId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 184)) return 184;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public long measurementTypesAdd(long MeasurementTypeManagerId, PersistentMMeasurementType measurementTypesVal) throws PersistenceException {
        return 0;
    }
    public void measurementTypesRem(long measurementTypesId) throws PersistenceException {
        
    }
    public MMeasurementTypeList measurementTypesGet(long MeasurementTypeManagerId) throws PersistenceException {
        return new MMeasurementTypeList(); // remote access for initialization only!
    }
    public void ThisSet(long MeasurementTypeManagerId, PersistentMeasurementTypeManager ThisVal) throws PersistenceException {
        
    }

}

