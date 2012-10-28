package persistence;

import model.*;

public class ConversionRateFacade{

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

	

	public ConversionRateFacade() {
	}

    public ConversionRateProxi newConversionRate() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theConversionRateFacade.getNextId();
        ConversionRate result = new ConversionRate(null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (ConversionRateProxi)PersistentProxi.createProxi(id, 120);
    }
    
    public ConversionRate getConversionRate(long ConversionRateId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 120)) return 120;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void fromUnitSet(long ConversionRateId, PersistentUnit fromUnitVal) throws PersistenceException {
        
    }
    public void toUnitSet(long ConversionRateId, PersistentUnit toUnitVal) throws PersistenceException {
        
    }
    public void conversionRateSet(long ConversionRateId, PersistentFraction conversionRateVal) throws PersistenceException {
        
    }
    public void ThisSet(long ConversionRateId, PersistentConversionRate ThisVal) throws PersistenceException {
        
    }

}

