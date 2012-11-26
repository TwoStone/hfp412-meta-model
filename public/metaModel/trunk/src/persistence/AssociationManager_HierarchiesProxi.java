package persistence;

import model.*;

import java.util.Iterator;

public class AssociationManager_HierarchiesProxi extends PersistentListProxi<PersistentMAHierarchy> {

  private MAHierarchyList list;
  private AssociationManager owner;

  public AssociationManager_HierarchiesProxi(AssociationManager owner) {
    this.owner = owner;
  }
  public MAHierarchyList getList() throws PersistenceException{
    if (this.list == null) {
      if (this.owner.isDelayed$Persistence()) {
        this.list = new MAHierarchyList();
      } else {
        this.list = ConnectionHandler
                    .getTheConnectionHandler()
                      .theAssociationManagerFacade.hierarchiesGet(this.owner.getId());
      }
    }
    return this.list;
  }
  public Iterator<PersistentMAHierarchy> iterator() throws PersistenceException{
    return this.getList().iterator(this);
  }
  public long getLength() throws PersistenceException{
	  return this.getList().getLength();
  }
  public void add(PersistentMAHierarchy entry) throws PersistenceException {
    if (entry != null) {
      MAHierarchyList list = this.getList();
      long entryId = 0;
      if (!this.owner.isDelayed$Persistence()) {
        entry.store();  	
        entryId = ConnectionHandler.getTheConnectionHandler().theAssociationManagerFacade
                       .hierarchiesAdd(owner.getId(), entry);
      }
      list.add((PersistentMAHierarchy)PersistentProxi.createListEntryProxi(entry.getId(),
                               entry.getClassId(),
                               entryId));
      
    }
  }
  protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    if (!this.owner.isDelayed$Persistence()) {
      ConnectionHandler.getTheConnectionHandler().theAssociationManagerFacade.hierarchiesRem(entry.getListEntryId());
    }
    
  }
  public AssociationManager_HierarchiesProxi copy(AssociationManager owner) throws PersistenceException {
  	AssociationManager_HierarchiesProxi result = new AssociationManager_HierarchiesProxi(owner);
  	result.list = this.getList().copy();
  	return result;
  } 
  public void store() throws PersistenceException {
  	java.util.Iterator<PersistentMAHierarchy> entries = (this.list == null ? new java.util.Vector<PersistentMAHierarchy>().iterator() : this.list.iterator(this));
  	while (entries.hasNext()){
  		PersistentMAHierarchy current = entries.next();
  		current.store();
      	long entryId = ConnectionHandler.getTheConnectionHandler().theAssociationManagerFacade
                       .hierarchiesAdd(owner.getId(), current);
        ((PersistentListEntryProxi)current).setListEntryId(entryId);
  	}
  }	
}
