package persistence;

import model.*;

public class ConversionFacade{

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

	

	public ConversionFacade() {
	}

    public ConversionProxi newConversion() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theConversionFacade.getNextId();
        Conversion result = new Conversion(null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (ConversionProxi)PersistentProxi.createProxi(id, 116);
    }
    
    public Conversion getConversion(long ConversionId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 116)) return 116;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void sourceSet(long ConversionId, PersistentUnit sourceVal) throws PersistenceException {
        
    }
    public void targetSet(long ConversionId, PersistentUnit targetVal) throws PersistenceException {
        
    }
    public void convFunctionSet(long ConversionId, PersistentFunction convFunctionVal) throws PersistenceException {
        
    }
    public void ThisSet(long ConversionId, PersistentConversion ThisVal) throws PersistenceException {
        
    }

}

