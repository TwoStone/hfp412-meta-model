package persistence;

import model.measurement.*;

public class MAccountTypeFacade{



	public MAccountTypeFacade() {
	}

    public MAccountTypeProxi newMAccountType(long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (MAccountTypeProxi)PersistentProxi.createProxi(createMinusStorePlus, 194);
        long id = ConnectionHandler.getTheConnectionHandler().theMQuantiObjectTypeFacade.getNextId();
        MAccountType result = new MAccountType(null,null,null,id);
        Cache.getTheCache().put(result);
        return (MAccountTypeProxi)PersistentProxi.createProxi(id, 194);
    }
    
    public MAccountTypeProxi newDelayedMAccountType() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theMQuantiObjectTypeFacade.getNextId();
        MAccountType result = new MAccountType(null,null,null,id);
        Cache.getTheCache().put(result);
        return (MAccountTypeProxi)PersistentProxi.createProxi(id, 194);
    }
    
    public MAccountType getMAccountType(long MAccountTypeId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long subAccountTypesAdd(long MAccountTypeId, PersistentMAccountType subAccountTypesVal) throws PersistenceException {
        return 0;
    }
    public void subAccountTypesRem(long subAccountTypesId) throws PersistenceException {
        
    }
    public MAccountTypeList subAccountTypesGet(long MAccountTypeId) throws PersistenceException {
        return new MAccountTypeList(); // remote access for initialization only!
    }

}

