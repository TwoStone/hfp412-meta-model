package persistence;

import model.measurement.*;

public class AccountManagerFacade{

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

	

	public AccountManagerFacade() {
	}

    public AccountManagerProxi getTheAccountManager() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theAccountManagerFacade.getNextId();
        AccountManager result = new AccountManager(null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (AccountManagerProxi)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().equals(result) ? -1 : 1), 141);
    }
    
    public AccountManager getAccountManager(long AccountManagerId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 141)) return 141;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public long accountsAdd(long AccountManagerId, PersistentAccount accountsVal) throws PersistenceException {
        return 0;
    }
    public void accountsRem(long accountsId) throws PersistenceException {
        
    }
    public AccountList accountsGet(long AccountManagerId) throws PersistenceException {
        return new AccountList(); // remote access for initialization only!
    }
    public void ThisSet(long AccountManagerId, PersistentAccountManager ThisVal) throws PersistenceException {
        
    }

}

