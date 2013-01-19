package persistence;

import model.abstractOperation.*;

import java.util.Iterator;

public class AssociationManager_HierarchiesProxi extends PersistentListProxi<PersistentHierarchy> {

  private HierarchyList list;
  private AssociationManager owner;

  public AssociationManager_HierarchiesProxi(AssociationManager owner) {
    this.owner = owner;
  }
  public HierarchyList getList() throws PersistenceException{
    if (this.list == null) {
      if (this.owner.isDelayed$Persistence()) {
        this.list = new HierarchyList();
      } else {
        this.list = ConnectionHandler
                    .getTheConnectionHandler()
                      .theAssociationManagerFacade.hierarchiesGet(this.owner.getId());
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
        entryId = ConnectionHandler.getTheConnectionHandler().theAssociationManagerFacade
                       .hierarchiesAdd(owner.getId(), entry);
      }
      list.add((PersistentHierarchy)PersistentProxi.createListEntryProxi(entry.getId(),
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
  	java.util.Iterator<PersistentHierarchy> entries = (this.list == null ? new java.util.Vector<PersistentHierarchy>().iterator() : this.list.iterator(this));
  	while (entries.hasNext()){
  		PersistentHierarchy current = entries.next();
  		current.store();
      	long entryId = ConnectionHandler.getTheConnectionHandler().theAssociationManagerFacade
                       .hierarchiesAdd(owner.getId(), current);
        ((PersistentListEntryProxi)current).setListEntryId(entryId);
  	}
  }	
}
