package persistence;

import model.meta.*;

public class CommonDateFacade{

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

	

	public CommonDateFacade() {
	}

    public CommonDateProxi newCommonDate(java.sql.Date createDate,java.sql.Date commitDate,long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (CommonDateProxi)PersistentProxi.createProxi(createMinusStorePlus, 113);
        long id = ConnectionHandler.getTheConnectionHandler().theCommonDateFacade.getNextId();
        CommonDate result = new CommonDate(createDate,commitDate,id);
        Cache.getTheCache().put(result);
        return (CommonDateProxi)PersistentProxi.createProxi(id, 113);
    }
    
    public CommonDateProxi newDelayedCommonDate(java.sql.Date createDate,java.sql.Date commitDate) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theCommonDateFacade.getNextId();
        CommonDate result = new CommonDate(createDate,commitDate,id);
        Cache.getTheCache().put(result);
        return (CommonDateProxi)PersistentProxi.createProxi(id, 113);
    }
    
    public CommonDate getCommonDate(long CommonDateId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 113)) return 113;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void createDateSet(long CommonDateId, java.sql.Date createDateVal) throws PersistenceException {
        
    }
    public void commitDateSet(long CommonDateId, java.sql.Date commitDateVal) throws PersistenceException {
        
    }

}

