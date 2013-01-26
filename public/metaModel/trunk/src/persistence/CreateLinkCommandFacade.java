package persistence;

import model.meta.*;

public class CreateLinkCommandFacade{

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

	

	public CreateLinkCommandFacade() {
	}

    public CreateLinkCommandProxi newCreateLinkCommand(long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (CreateLinkCommandProxi)PersistentProxi.createProxi(createMinusStorePlus, 160);
        long id = ConnectionHandler.getTheConnectionHandler().theCreateLinkCommandFacade.getNextId();
        CreateLinkCommand result = new CreateLinkCommand(null,null,null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (CreateLinkCommandProxi)PersistentProxi.createProxi(id, 160);
    }
    
    public CreateLinkCommandProxi newDelayedCreateLinkCommand() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theCreateLinkCommandFacade.getNextId();
        CreateLinkCommand result = new CreateLinkCommand(null,null,null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (CreateLinkCommandProxi)PersistentProxi.createProxi(id, 160);
    }
    
    public CreateLinkCommand getCreateLinkCommand(long CreateLinkCommandId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 160)) return 160;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void typeSet(long CreateLinkCommandId, PersistentAssociation typeVal) throws PersistenceException {
        
    }
    public void sourceSet(long CreateLinkCommandId, PersistentInstanceObject sourceVal) throws PersistenceException {
        
    }
    public void targetSet(long CreateLinkCommandId, PersistentInstanceObject targetVal) throws PersistenceException {
        
    }
    public void invokerSet(long CreateLinkCommandId, Invoker invokerVal) throws PersistenceException {
        
    }
    public void commandReceiverSet(long CreateLinkCommandId, PersistentLinkManager commandReceiverVal) throws PersistenceException {
        
    }
    public void myCommonDateSet(long CreateLinkCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        
    }

}

