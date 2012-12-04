package persistence;

import model.*;

public class TypeManagerFacade{

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

	

	public TypeManagerFacade() {
	}

    public TypeManagerProxi getTheTypeManager() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theTypeManagerFacade.getNextId();
        TypeManager result = new TypeManager(null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (TypeManagerProxi)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().equals(result) ? -1 : 1), 118);
    }
    
    public TypeManager getTypeManager(long TypeManagerId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 118)) return 118;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public long atomicTypesAdd(long TypeManagerId, PersistentMAtomicType atomicTypesVal) throws PersistenceException {
        return 0;
    }
    public void atomicTypesRem(long atomicTypesId) throws PersistenceException {
        
    }
    public MAtomicTypeList atomicTypesGet(long TypeManagerId) throws PersistenceException {
        return new MAtomicTypeList(); // remote access for initialization only!
    }
    public long productTypesAdd(long TypeManagerId, PersistentMProductType productTypesVal) throws PersistenceException {
        return 0;
    }
    public void productTypesRem(long productTypesId) throws PersistenceException {
        
    }
    public MProductTypeList productTypesGet(long TypeManagerId) throws PersistenceException {
        return new MProductTypeList(); // remote access for initialization only!
    }
    public long sumTypesAdd(long TypeManagerId, PersistentMSumType sumTypesVal) throws PersistenceException {
        return 0;
    }
    public void sumTypesRem(long sumTypesId) throws PersistenceException {
        
    }
    public MSumTypeList sumTypesGet(long TypeManagerId) throws PersistenceException {
        return new MSumTypeList(); // remote access for initialization only!
    }
    public void ThisSet(long TypeManagerId, PersistentTypeManager ThisVal) throws PersistenceException {
        
    }

}

