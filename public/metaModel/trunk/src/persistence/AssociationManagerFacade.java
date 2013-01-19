package persistence;

import model.abstractOperation.*;

public class AssociationManagerFacade{

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

	

	public AssociationManagerFacade() {
	}

    public AssociationManagerProxi getTheAssociationManager() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theAssociationManagerFacade.getNextId();
        AssociationManager result = new AssociationManager(null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (AssociationManagerProxi)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().equals(result) ? -1 : 1), 141);
    }
    
    public AssociationManager getAssociationManager(long AssociationManagerId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 141)) return 141;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public long associationsAdd(long AssociationManagerId, PersistentAssociation associationsVal) throws PersistenceException {
        return 0;
    }
    public void associationsRem(long associationsId) throws PersistenceException {
        
    }
    public AssociationList associationsGet(long AssociationManagerId) throws PersistenceException {
        return new AssociationList(); // remote access for initialization only!
    }
    public long hierarchiesAdd(long AssociationManagerId, PersistentHierarchy hierarchiesVal) throws PersistenceException {
        return 0;
    }
    public void hierarchiesRem(long hierarchiesId) throws PersistenceException {
        
    }
    public HierarchyList hierarchiesGet(long AssociationManagerId) throws PersistenceException {
        return new HierarchyList(); // remote access for initialization only!
    }
    public void ThisSet(long AssociationManagerId, PersistentAssociationManager ThisVal) throws PersistenceException {
        
    }

}

