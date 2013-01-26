package persistence;

import model.messageOrLink.*;

public class LinkFacade{



	public LinkFacade() {
	}

    public LinkProxi newLink(long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (LinkProxi)PersistentProxi.createProxi(createMinusStorePlus, 141);
        long id = ConnectionHandler.getTheConnectionHandler().theMessageOrLinkFacade.getNextId();
        Link result = new Link(null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (LinkProxi)PersistentProxi.createProxi(id, 141);
    }
    
    public LinkProxi newDelayedLink() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theMessageOrLinkFacade.getNextId();
        Link result = new Link(null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (LinkProxi)PersistentProxi.createProxi(id, 141);
    }
    
    public Link getLink(long LinkId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public void typeSet(long LinkId, PersistentAssociation typeVal) throws PersistenceException {
        
    }

}

