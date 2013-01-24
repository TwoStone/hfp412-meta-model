package persistence;

import model.typeSystem.*;

public class MAtomicTypeFacade{



	public MAtomicTypeFacade() {
	}

    public MAtomicTypeProxi newMAtomicType(String name,long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (MAtomicTypeProxi)PersistentProxi.createProxi(createMinusStorePlus, 112);
        long id = ConnectionHandler.getTheConnectionHandler().theMTypeFacade.getNextId();
        MAtomicType result = new MAtomicType(null,name,null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (MAtomicTypeProxi)PersistentProxi.createProxi(id, 112);
    }
    
    public MAtomicTypeProxi newDelayedMAtomicType(String name) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theMTypeFacade.getNextId();
        MAtomicType result = new MAtomicType(null,name,null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (MAtomicTypeProxi)PersistentProxi.createProxi(id, 112);
    }
    
    public MAtomicType getMAtomicType(long MAtomicTypeId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public MAtomicTypeSearchList getMAtomicTypeByName(String name) throws PersistenceException {
        MAtomicTypeSearchList result = new MAtomicTypeSearchList();
        java.util.Iterator<?> candidates;
        candidates = Cache.getTheCache().iterator(112);
        while (candidates.hasNext()){
            PersistentMAtomicType current = (PersistentMAtomicType)((PersistentRoot)candidates.next()).getTheObject();
            if (current != null && !current.isDltd() && current.getName().equals(name))
                result.add((PersistentMAtomicType)PersistentProxi.createProxi(current.getId(), current.getClassId()));
        }
        return result;
    }
    public void nameSet(long MAtomicTypeId, String nameVal) throws PersistenceException {
        
    }
    public void singletonTypeSet(long MAtomicTypeId, PersistentMBoolean singletonTypeVal) throws PersistenceException {
        
    }
    public void abstractTypeSet(long MAtomicTypeId, PersistentMBoolean abstractTypeVal) throws PersistenceException {
        
    }
    public void aspectSet(long MAtomicTypeId, PersistentMAspect aspectVal) throws PersistenceException {
        
    }
    public void superTypeSet(long MAtomicTypeId, PersistentMAtomicType superTypeVal) throws PersistenceException {
        
    }
    public MAtomicTypeSearchList inverseGetAspect(long objectId, long classId)throws PersistenceException{
        MAtomicTypeSearchList result = new MAtomicTypeSearchList();
        java.util.Iterator<PersistentInCacheProxi> candidates;
        candidates = Cache.getTheCache().iterator(112);
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
        candidates = Cache.getTheCache().iterator(112);
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

