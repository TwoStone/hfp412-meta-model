package persistence;

import model.*;

public class MAssociationFacade{

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

	

	public MAssociationFacade() {
	}

    public MAssociationProxi newMAssociation(String name,long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (MAssociationProxi)PersistentProxi.createProxi(createMinusStorePlus, 143);
        long id = ConnectionHandler.getTheConnectionHandler().theMAssociationFacade.getNextId();
        MAssociation result = new MAssociation(name,null,null,null,id);
        Cache.getTheCache().put(result);
        return (MAssociationProxi)PersistentProxi.createProxi(id, 143);
    }
    
    public MAssociationProxi newDelayedMAssociation(String name) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theMAssociationFacade.getNextId();
        MAssociation result = new MAssociation(name,null,null,null,id);
        Cache.getTheCache().put(result);
        return (MAssociationProxi)PersistentProxi.createProxi(id, 143);
    }
    
    public MAssociation getMAssociation(long MAssociationId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 143)) return 143;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void nameSet(long MAssociationId, String nameVal) throws PersistenceException {
        
    }
    public void sourceSet(long MAssociationId, MType sourceVal) throws PersistenceException {
        
    }
    public void targetSet(long MAssociationId, MType targetVal) throws PersistenceException {
        
    }
    public long hierarchiesAdd(long MAssociationId, PersistentMAHierarchy hierarchiesVal) throws PersistenceException {
        return 0;
    }
    public void hierarchiesRem(long hierarchiesId) throws PersistenceException {
        
    }
    public MAHierarchyList hierarchiesGet(long MAssociationId) throws PersistenceException {
        return new MAHierarchyList(); // remote access for initialization only!
    }
    public void ThisSet(long MAssociationId, PersistentMAssociation ThisVal) throws PersistenceException {
        
    }
    public MAssociationSearchList inverseGetHierarchies(long objectId, long classId)throws PersistenceException{
        MAssociationSearchList result = new MAssociationSearchList();
        java.util.Iterator<PersistentInCacheProxi> candidates;
        candidates = Cache.getTheCache().iterator(143);
        while (candidates.hasNext()){
            PersistentMAssociation current = (PersistentMAssociation)((PersistentRoot)candidates.next()).getTheObject();
            if (current != null){
                java.util.Iterator iterator = ((MAssociation_HierarchiesProxi)current.getHierarchies()).iterator();
                while(iterator.hasNext()){
                    PersistentProxi item = (PersistentProxi)iterator.next();
                    if (!item.isDltd() && item.getClassId() == classId && item.getId() == objectId) {
                        PersistentMAssociation proxi = (PersistentMAssociation)PersistentProxi.createProxi(current.getId(), current.getClassId());
                        result.add((PersistentMAssociation)proxi.getThis());
                    }
                }
            }
        }
        return result;
    }

}

