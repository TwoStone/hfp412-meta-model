package persistence;

import model.abstractOperation.*;

import java.util.Iterator;

public class Association_HierarchiesProxi extends PersistentListProxi<PersistentHierarchy> {

  private HierarchyList list;
  private Association owner;

  public Association_HierarchiesProxi(Association owner) {
    this.owner = owner;
  }
  public HierarchyList getList() throws PersistenceException{
    if (this.list == null) {
      if (this.owner.isDelayed$Persistence()) {
        this.list = new HierarchyList();
      } else {
        this.list = ConnectionHandler
                    .getTheConnectionHandler()
                      .theAssociationFacade.hierarchiesGet(this.owner.getId());
      }
    }
    return this.list;
  }
  public Iterator<PersistentHierarchy> iterator() throws PersistenceException{
    return this.getList().iterator(this);
  }
  public long getLength() throws PersistenceException{
	  return this.getList().getLength();
  }
  public void add(PersistentHierarchy entry) throws PersistenceException {
    if (entry != null) {
      HierarchyList list = this.getList();
      long entryId = 0;
      if (!this.owner.isDelayed$Persistence()) {
        entry.store();  	
        entryId = ConnectionHandler.getTheConnectionHandler().theAssociationFacade
                       .hierarchiesAdd(owner.getId(), entry);
      }
      list.add((PersistentHierarchy)PersistentProxi.createListEntryProxi(entry.getId(),
                               entry.getClassId(),
                               entryId));
      
    }
  }
  protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    if (!this.owner.isDelayed$Persistence()) {
      ConnectionHandler.getTheConnectionHandler().theAssociationFacade.hierarchiesRem(entry.getListEntryId());
    }
    
  }
  public Association_HierarchiesProxi copy(Association owner) throws PersistenceException {
  	Association_HierarchiesProxi result = new Association_HierarchiesProxi(owner);
  	result.list = this.getList().copy();
  	return result;
  } 
  public void store() throws PersistenceException {
  	java.util.Iterator<PersistentHierarchy> entries = (this.list == null ? new java.util.Vector<PersistentHierarchy>().iterator() : this.list.iterator(this));
  	while (entries.hasNext()){
  		PersistentHierarchy current = entries.next();
  		current.store();
      	long entryId = ConnectionHandler.getTheConnectionHandler().theAssociationFacade
                       .hierarchiesAdd(owner.getId(), current);
        ((PersistentListEntryProxi)current).setListEntryId(entryId);
  	}
  }	
}
