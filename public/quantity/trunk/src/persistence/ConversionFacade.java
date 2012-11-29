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

    public ConversionProxi newConversion(long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (ConversionProxi)PersistentProxi.createProxi(createMinusStorePlus, 133);
        long id = ConnectionHandler.getTheConnectionHandler().theConversionFacade.getNextId();
        Conversion result = new Conversion(null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (ConversionProxi)PersistentProxi.createProxi(id, 133);
    }
    
    public ConversionProxi newDelayedConversion() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theConversionFacade.getNextId();
        Conversion result = new Conversion(null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (ConversionProxi)PersistentProxi.createProxi(id, 133);
    }
    
    public Conversion getConversion(long ConversionId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 133)) return 133;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void sourceSet(long ConversionId, PersistentUnit sourceVal) throws PersistenceException {
        
    }
    public void typeSet(long ConversionId, PersistentUnitType typeVal) throws PersistenceException {
        
    }
    public void myFunctionSet(long ConversionId, PersistentFunction myFunctionVal) throws PersistenceException {
        
    }
    public void ThisSet(long ConversionId, PersistentConversion ThisVal) throws PersistenceException {
        
    }
    public ConversionSearchList inverseGetSource(long objectId, long classId)throws PersistenceException{
        ConversionSearchList result = new ConversionSearchList();
        java.util.Iterator<PersistentInCacheProxi> candidates;
        candidates = Cache.getTheCache().iterator(133);
        while (candidates.hasNext()){
            PersistentConversion current = (PersistentConversion)((PersistentRoot)candidates.next()).getTheObject();
            if (current != null && !current.isDltd() && current.getSource() != null){
                if (current.getSource().getClassId() == classId && current.getSource().getId() == objectId) {
                    PersistentConversion proxi = (PersistentConversion)PersistentProxi.createProxi(current.getId(), current.getClassId());
                    result.add((PersistentConversion)proxi.getThis());
                }
            }
        }
        return result;
    }

}

