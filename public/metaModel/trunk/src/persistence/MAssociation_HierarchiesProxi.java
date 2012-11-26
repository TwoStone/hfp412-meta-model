package persistence;

import model.*;

import java.util.Iterator;

public class MAssociation_HierarchiesProxi extends PersistentListProxi<PersistentMAHierarchy> {

  private MAHierarchyList list;
  private MAssociation owner;

  public MAssociation_HierarchiesProxi(MAssociation owner) {
    this.owner = owner;
  }
  public MAHierarchyList getList() throws PersistenceException{
    if (this.list == null) {
      if (this.owner.isDelayed$Persistence()) {
        this.list = new MAHierarchyList();
      } else {
        this.list = ConnectionHandler
                    .getTheConnectionHandler()
                      .theMAssociationFacade.hierarchiesGet(this.owner.getId());
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
        entryId = ConnectionHandler.getTheConnectionHandler().theMAssociationFacade
                       .hierarchiesAdd(owner.getId(), entry);
      }
      list.add((PersistentMAHierarchy)PersistentProxi.createListEntryProxi(entry.getId(),
                               entry.getClassId(),
                               entryId));
      
    }
  }
  protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    if (!this.owner.isDelayed$Persistence()) {
      ConnectionHandler.getTheConnectionHandler().theMAssociationFacade.hierarchiesRem(entry.getListEntryId());
    }
    
  }
  public MAssociation_HierarchiesProxi copy(MAssociation owner) throws PersistenceException {
  	MAssociation_HierarchiesProxi result = new MAssociation_HierarchiesProxi(owner);
  	result.list = this.getList().copy();
  	return result;
  } 
  public void store() throws PersistenceException {
  	java.util.Iterator<PersistentMAHierarchy> entries = (this.list == null ? new java.util.Vector<PersistentMAHierarchy>().iterator() : this.list.iterator(this));
  	while (entries.hasNext()){
  		PersistentMAHierarchy current = entries.next();
  		current.store();
      	long entryId = ConnectionHandler.getTheConnectionHandler().theMAssociationFacade
                       .hierarchiesAdd(owner.getId(), current);
        ((PersistentListEntryProxi)current).setListEntryId(entryId);
  	}
  }	
}
