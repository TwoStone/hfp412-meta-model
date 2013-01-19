package persistence;

import model.abstractOperation.*;

public class AssociationFacade{

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

	

	public AssociationFacade() {
	}

    public AssociationProxi newAssociation(String name,long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (AssociationProxi)PersistentProxi.createProxi(createMinusStorePlus, 223);
        long id = ConnectionHandler.getTheConnectionHandler().theAssociationFacade.getNextId();
        Association result = new Association(name,null,null,null,id);
        Cache.getTheCache().put(result);
        return (AssociationProxi)PersistentProxi.createProxi(id, 223);
    }
    
    public AssociationProxi newDelayedAssociation(String name) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theAssociationFacade.getNextId();
        Association result = new Association(name,null,null,null,id);
        Cache.getTheCache().put(result);
        return (AssociationProxi)PersistentProxi.createProxi(id, 223);
    }
    
    public Association getAssociation(long AssociationId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 223)) return 223;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void nameSet(long AssociationId, String nameVal) throws PersistenceException {
        
    }
    public void sourceSet(long AssociationId, PersistentMType sourceVal) throws PersistenceException {
        
    }
    public void targetSet(long AssociationId, PersistentMType targetVal) throws PersistenceException {
        
    }
    public long hierarchiesAdd(long AssociationId, PersistentHierarchy hierarchiesVal) throws PersistenceException {
        return 0;
    }
    public void hierarchiesRem(long hierarchiesId) throws PersistenceException {
        
    }
    public HierarchyList hierarchiesGet(long AssociationId) throws PersistenceException {
        return new HierarchyList(); // remote access for initialization only!
    }
    public void ThisSet(long AssociationId, PersistentAssociation ThisVal) throws PersistenceException {
        
    }
    public AssociationSearchList inverseGetHierarchies(long objectId, long classId)throws PersistenceException{
        AssociationSearchList result = new AssociationSearchList();
        java.util.Iterator<PersistentInCacheProxi> candidates;
        candidates = Cache.getTheCache().iterator(223);
        while (candidates.hasNext()){
            PersistentAssociation current = (PersistentAssociation)((PersistentRoot)candidates.next()).getTheObject();
            if (current != null){
                java.util.Iterator iterator = ((Association_HierarchiesProxi)current.getHierarchies()).iterator();
                while(iterator.hasNext()){
                    PersistentProxi item = (PersistentProxi)iterator.next();
                    if (!item.isDltd() && item.getClassId() == classId && item.getId() == objectId) {
                        PersistentAssociation proxi = (PersistentAssociation)PersistentProxi.createProxi(current.getId(), current.getClassId());
                        result.add((PersistentAssociation)proxi.getThis());
                    }
                }
            }
        }
        return result;
    }

}

