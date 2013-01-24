package persistence;

import model.measurement.*;

public class AccountFacade{



	public AccountFacade() {
	}

    public AccountProxi newAccount(long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (AccountProxi)PersistentProxi.createProxi(createMinusStorePlus, 181);
        long id = ConnectionHandler.getTheConnectionHandler().theQuantifObjectFacade.getNextId();
        Account result = new Account(null,null,null,id);
        Cache.getTheCache().put(result);
        return (AccountProxi)PersistentProxi.createProxi(id, 181);
    }
    
    public AccountProxi newDelayedAccount() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theQuantifObjectFacade.getNextId();
        Account result = new Account(null,null,null,id);
        Cache.getTheCache().put(result);
        return (AccountProxi)PersistentProxi.createProxi(id, 181);
    }
    
    public Account getAccount(long AccountId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public void typeSet(long AccountId, PersistentMAccountType typeVal) throws PersistenceException {
        
    }
    public long subAccountsAdd(long AccountId, PersistentAccount subAccountsVal) throws PersistenceException {
        return 0;
    }
    public void subAccountsRem(long subAccountsId) throws PersistenceException {
        
    }
    public AccountList subAccountsGet(long AccountId) throws PersistenceException {
        return new AccountList(); // remote access for initialization only!
    }
    public long entriesAdd(long AccountId, PersistentMeasurement entriesVal) throws PersistenceException {
        return 0;
    }
    public void entriesRem(long entriesId) throws PersistenceException {
        
    }
    public MeasurementList entriesGet(long AccountId) throws PersistenceException {
        return new MeasurementList(); // remote access for initialization only!
    }

}

