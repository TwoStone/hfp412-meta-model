package persistence;

import model.messageOrLink.*;

public class LinkManagerFacade{

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

	

	public LinkManagerFacade() {
	}

    public LinkManagerProxi getTheLinkManager() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theLinkManagerFacade.getNextId();
        LinkManager result = new LinkManager(null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (LinkManagerProxi)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().equals(result) ? -1 : 1), 186);
    }
    
    public LinkManager getLinkManager(long LinkManagerId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 186)) return 186;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public long linksAdd(long LinkManagerId, PersistentLink linksVal) throws PersistenceException {
        return 0;
    }
    public void linksRem(long linksId) throws PersistenceException {
        
    }
    public LinkList linksGet(long LinkManagerId) throws PersistenceException {
        return new LinkList(); // remote access for initialization only!
    }
    public void ThisSet(long LinkManagerId, PersistentLinkManager ThisVal) throws PersistenceException {
        
    }

}

