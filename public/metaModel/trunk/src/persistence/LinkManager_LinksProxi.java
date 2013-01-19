package persistence;

import model.messageOrLink.*;

import java.util.Iterator;

public class LinkManager_LinksProxi extends PersistentListProxi<PersistentLink> {

  private LinkList list;
  private LinkManager owner;

  public LinkManager_LinksProxi(LinkManager owner) {
    this.owner = owner;
  }
  public LinkList getList() throws PersistenceException{
    if (this.list == null) {
      if (this.owner.isDelayed$Persistence()) {
        this.list = new LinkList();
      } else {
        this.list = ConnectionHandler
                    .getTheConnectionHandler()
                      .theLinkManagerFacade.linksGet(this.owner.getId());
      }
    }
    return this.list;
  }
  public Iterator<PersistentLink> iterator() throws PersistenceException{
    return this.getList().iterator(this);
  }
  public long getLength() throws PersistenceException{
	  return this.getList().getLength();
  }
  public void add(PersistentLink entry) throws PersistenceException {
    if (entry != null) {
      LinkList list = this.getList();
      long entryId = 0;
      if (!this.owner.isDelayed$Persistence()) {
        entry.store();  	
        entryId = ConnectionHandler.getTheConnectionHandler().theLinkManagerFacade
                       .linksAdd(owner.getId(), entry);
      }
      list.add((PersistentLink)PersistentProxi.createListEntryProxi(entry.getId(),
                               entry.getClassId(),
                               entryId));
      
    }
  }
  protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    if (!this.owner.isDelayed$Persistence()) {
      ConnectionHandler.getTheConnectionHandler().theLinkManagerFacade.linksRem(entry.getListEntryId());
    }
    
  }
  public LinkManager_LinksProxi copy(LinkManager owner) throws PersistenceException {
  	LinkManager_LinksProxi result = new LinkManager_LinksProxi(owner);
  	result.list = this.getList().copy();
  	return result;
  } 
  public void store() throws PersistenceException {
  	java.util.Iterator<PersistentLink> entries = (this.list == null ? new java.util.Vector<PersistentLink>().iterator() : this.list.iterator(this));
  	while (entries.hasNext()){
  		PersistentLink current = entries.next();
  		current.store();
      	long entryId = ConnectionHandler.getTheConnectionHandler().theLinkManagerFacade
                       .linksAdd(owner.getId(), current);
        ((PersistentListEntryProxi)current).setListEntryId(entryId);
  	}
  }	
}
