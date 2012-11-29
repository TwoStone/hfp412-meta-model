package persistence;

import model.*;

public class CompUnitFacade{



	public CompUnitFacade() {
	}

    public CompUnitProxi newCompUnit(String name,long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (CompUnitProxi)PersistentProxi.createProxi(createMinusStorePlus, 131);
        long id = ConnectionHandler.getTheConnectionHandler().theAbsUnitFacade.getNextId();
        CompUnit result = new CompUnit(null,name,null,null,id);
        Cache.getTheCache().put(result);
        return (CompUnitProxi)PersistentProxi.createProxi(id, 131);
    }
    
    public CompUnitProxi newDelayedCompUnit(String name) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theAbsUnitFacade.getNextId();
        CompUnit result = new CompUnit(null,name,null,null,id);
        Cache.getTheCache().put(result);
        return (CompUnitProxi)PersistentProxi.createProxi(id, 131);
    }
    
    public CompUnit getCompUnit(long CompUnitId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long refsAdd(long CompUnitId, PersistentReference refsVal) throws PersistenceException {
        return 0;
    }
    public void refsRem(long refsId) throws PersistenceException {
        
    }
    public ReferenceList refsGet(long CompUnitId) throws PersistenceException {
        return new ReferenceList(); // remote access for initialization only!
    }
    public void isFinalSet(long CompUnitId, PersistentBooleanValue isFinalVal) throws PersistenceException {
        
    }

}

