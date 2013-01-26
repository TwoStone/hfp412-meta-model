package persistence;

import model.abstractOperation.*;

public class AssociationFacade{



	public AssociationFacade() {
	}

    public AssociationProxi newAssociation(String name,long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (AssociationProxi)PersistentProxi.createProxi(createMinusStorePlus, 117);
        long id = ConnectionHandler.getTheConnectionHandler().theAbsOperationFacade.getNextId();
        Association result = new Association(name,null,null,null,id);
        Cache.getTheCache().put(result);
        return (AssociationProxi)PersistentProxi.createProxi(id, 117);
    }
    
    public AssociationProxi newDelayedAssociation(String name) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theAbsOperationFacade.getNextId();
        Association result = new Association(name,null,null,null,id);
        Cache.getTheCache().put(result);
        return (AssociationProxi)PersistentProxi.createProxi(id, 117);
    }
    
    public Association getAssociation(long AssociationId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long hierarchiesAdd(long AssociationId, PersistentHierarchy hierarchiesVal) throws PersistenceException {
        return 0;
    }
    public void hierarchiesRem(long hierarchiesId) throws PersistenceException {
        
    }
    public HierarchyList hierarchiesGet(long AssociationId) throws PersistenceException {
        return new HierarchyList(); // remote access for initialization only!
    }
    public AssociationSearchList inverseGetHierarchies(long objectId, long classId)throws PersistenceException{
        AssociationSearchList result = new AssociationSearchList();
        java.util.Iterator<PersistentInCacheProxi> candidates;
        candidates = Cache.getTheCache().iterator(117);
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

