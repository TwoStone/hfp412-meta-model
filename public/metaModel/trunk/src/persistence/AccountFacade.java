package persistence;

import model.measurement.*;

public class AccountFacade{

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

	

	public AccountFacade() {
	}

    public AccountProxi newAccount(long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (AccountProxi)PersistentProxi.createProxi(createMinusStorePlus, 196);
        long id = ConnectionHandler.getTheConnectionHandler().theAccountFacade.getNextId();
        Account result = new Account(null,null,id);
        Cache.getTheCache().put(result);
        return (AccountProxi)PersistentProxi.createProxi(id, 196);
    }
    
    public AccountProxi newDelayedAccount() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theAccountFacade.getNextId();
        Account result = new Account(null,null,id);
        Cache.getTheCache().put(result);
        return (AccountProxi)PersistentProxi.createProxi(id, 196);
    }
    
    public Account getAccount(long AccountId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 196)) return 196;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
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
    public void ThisSet(long AccountId, PersistentAccount ThisVal) throws PersistenceException {
        
    }

}

