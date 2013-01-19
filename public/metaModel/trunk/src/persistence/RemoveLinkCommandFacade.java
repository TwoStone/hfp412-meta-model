package persistence;

import model.meta.*;

public class RemoveLinkCommandFacade{

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

	

	public RemoveLinkCommandFacade() {
	}

    public RemoveLinkCommandProxi newRemoveLinkCommand(long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (RemoveLinkCommandProxi)PersistentProxi.createProxi(createMinusStorePlus, 117);
        long id = ConnectionHandler.getTheConnectionHandler().theRemoveLinkCommandFacade.getNextId();
        RemoveLinkCommand result = new RemoveLinkCommand(null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (RemoveLinkCommandProxi)PersistentProxi.createProxi(id, 117);
    }
    
    public RemoveLinkCommandProxi newDelayedRemoveLinkCommand() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theRemoveLinkCommandFacade.getNextId();
        RemoveLinkCommand result = new RemoveLinkCommand(null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (RemoveLinkCommandProxi)PersistentProxi.createProxi(id, 117);
    }
    
    public RemoveLinkCommand getRemoveLinkCommand(long RemoveLinkCommandId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 117)) return 117;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void linkSet(long RemoveLinkCommandId, PersistentLink linkVal) throws PersistenceException {
        
    }
    public void invokerSet(long RemoveLinkCommandId, Invoker invokerVal) throws PersistenceException {
        
    }
    public void commandReceiverSet(long RemoveLinkCommandId, PersistentLinkManager commandReceiverVal) throws PersistenceException {
        
    }
    public void myCommonDateSet(long RemoveLinkCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        
    }

}

