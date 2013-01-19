package persistence;

import model.measurement.*;

public class AccountTypeManagerFacade{

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

	

	public AccountTypeManagerFacade() {
	}

    public AccountTypeManagerProxi getTheAccountTypeManager() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theAccountTypeManagerFacade.getNextId();
        AccountTypeManager result = new AccountTypeManager(null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (AccountTypeManagerProxi)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().equals(result) ? -1 : 1), 128);
    }
    
    public AccountTypeManager getAccountTypeManager(long AccountTypeManagerId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 128)) return 128;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public long accountTypesAdd(long AccountTypeManagerId, PersistentMAccountType accountTypesVal) throws PersistenceException {
        return 0;
    }
    public void accountTypesRem(long accountTypesId) throws PersistenceException {
        
    }
    public MAccountTypeList accountTypesGet(long AccountTypeManagerId) throws PersistenceException {
        return new MAccountTypeList(); // remote access for initialization only!
    }
    public void ThisSet(long AccountTypeManagerId, PersistentAccountTypeManager ThisVal) throws PersistenceException {
        
    }

}

