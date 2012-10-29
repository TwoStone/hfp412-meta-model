package persistence;

import model.*;

public class CompUnitFacade{



	public CompUnitFacade() {
	}

    public CompUnitProxi newCompUnit(String name) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theAbsUnitFacade.getNextId();
        CompUnit result = new CompUnit(null,name,null,id);
        Cache.getTheCache().put(result);
        return (CompUnitProxi)PersistentProxi.createProxi(id, 118);
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

}

