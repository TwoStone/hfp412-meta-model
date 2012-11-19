package persistence;

import model.*;

public class CompUnitTypeFacade{



	public CompUnitTypeFacade() {
	}

    public CompUnitTypeProxi newCompUnitType(String name,long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (CompUnitTypeProxi)PersistentProxi.createProxi(createMinusStorePlus, 125);
        long id = ConnectionHandler.getTheConnectionHandler().theAbsUnitTypeFacade.getNextId();
        CompUnitType result = new CompUnitType(null,name,null,null,id);
        Cache.getTheCache().put(result);
        return (CompUnitTypeProxi)PersistentProxi.createProxi(id, 125);
    }
    
    public CompUnitTypeProxi newDelayedCompUnitType(String name) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theAbsUnitTypeFacade.getNextId();
        CompUnitType result = new CompUnitType(null,name,null,null,id);
        Cache.getTheCache().put(result);
        return (CompUnitTypeProxi)PersistentProxi.createProxi(id, 125);
    }
    
    public CompUnitType getCompUnitType(long CompUnitTypeId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long refsAdd(long CompUnitTypeId, PersistentReferenceType refsVal) throws PersistenceException {
        return 0;
    }
    public void refsRem(long refsId) throws PersistenceException {
        
    }
    public ReferenceTypeList refsGet(long CompUnitTypeId) throws PersistenceException {
        return new ReferenceTypeList(); // remote access for initialization only!
    }
    public void isFinalSet(long CompUnitTypeId, PersistentBooleanValue isFinalVal) throws PersistenceException {
        
    }

}

