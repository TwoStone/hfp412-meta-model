package persistence;

import model.*;

public class MAtomicTypeFacade{

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

	

	public MAtomicTypeFacade() {
	}

    public MAtomicTypeProxi newMAtomicType(String name,long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (MAtomicTypeProxi)PersistentProxi.createProxi(createMinusStorePlus, 102);
        long id = ConnectionHandler.getTheConnectionHandler().theMAtomicTypeFacade.getNextId();
        MAtomicType result = new MAtomicType(name,null,null,null,id);
        Cache.getTheCache().put(result);
        return (MAtomicTypeProxi)PersistentProxi.createProxi(id, 102);
    }
    
    public MAtomicTypeProxi newDelayedMAtomicType(String name) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theMAtomicTypeFacade.getNextId();
        MAtomicType result = new MAtomicType(name,null,null,null,id);
        Cache.getTheCache().put(result);
        return (MAtomicTypeProxi)PersistentProxi.createProxi(id, 102);
    }
    
    public MAtomicType getMAtomicType(long MAtomicTypeId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 102)) return 102;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public MAtomicTypeSearchList getMAtomicTypeByName(String name) throws PersistenceException {
        MAtomicTypeSearchList result = new MAtomicTypeSearchList();
        java.util.Iterator<?> candidates;
        candidates = Cache.getTheCache().iterator(102);
        while (candidates.hasNext()){
            PersistentMAtomicType current = (PersistentMAtomicType)((PersistentRoot)candidates.next()).getTheObject();
            if (current != null && !current.isDltd() && current.getName().equals(name))
                result.add((PersistentMAtomicType)PersistentProxi.createProxi(current.getId(), current.getClassId()));
        }
        return result;
    }
    public void nameSet(long MAtomicTypeId, String nameVal) throws PersistenceException {
        
    }
    public void aspectSet(long MAtomicTypeId, PersistentMAspect aspectVal) throws PersistenceException {
        
    }
    public void superTypeSet(long MAtomicTypeId, PersistentMAtomicType superTypeVal) throws PersistenceException {
        
    }
    public void ThisSet(long MAtomicTypeId, PersistentMAtomicType ThisVal) throws PersistenceException {
        
    }
    public MAtomicTypeSearchList inverseGetAspect(long objectId, long classId)throws PersistenceException{
        MAtomicTypeSearchList result = new MAtomicTypeSearchList();
        java.util.Iterator<PersistentInCacheProxi> candidates;
        candidates = Cache.getTheCache().iterator(102);
        while (candidates.hasNext()){
            PersistentMAtomicType current = (PersistentMAtomicType)((PersistentRoot)candidates.next()).getTheObject();
            if (current != null && !current.isDltd() && current.getAspect() != null){
                if (current.getAspect().getClassId() == classId && current.getAspect().getId() == objectId) {
                    PersistentMAtomicType proxi = (PersistentMAtomicType)PersistentProxi.createProxi(current.getId(), current.getClassId());
                    result.add((PersistentMAtomicType)proxi.getThis());
                }
            }
        }
        return result;
    }
    public MAtomicTypeSearchList inverseGetSuperType(long objectId, long classId)throws PersistenceException{
        MAtomicTypeSearchList result = new MAtomicTypeSearchList();
        java.util.Iterator<PersistentInCacheProxi> candidates;
        candidates = Cache.getTheCache().iterator(102);
        while (candidates.hasNext()){
            PersistentMAtomicType current = (PersistentMAtomicType)((PersistentRoot)candidates.next()).getTheObject();
            if (current != null && !current.isDltd() && current.getSuperType() != null){
                if (current.getSuperType().getClassId() == classId && current.getSuperType().getId() == objectId) {
                    PersistentMAtomicType proxi = (PersistentMAtomicType)PersistentProxi.createProxi(current.getId(), current.getClassId());
                    result.add((PersistentMAtomicType)proxi.getThis());
                }
            }
        }
        return result;
    }

}

