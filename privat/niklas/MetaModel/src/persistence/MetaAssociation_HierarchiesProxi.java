package persistence;

import model.*;

import java.util.Iterator;

public class MetaAssociation_HierarchiesProxi extends PersistentListProxi<PersistentMetaHierarchy> {

  private MetaHierarchyList list;
  private MetaAssociation owner;

  public MetaAssociation_HierarchiesProxi(MetaAssociation owner) {
    this.owner = owner;
  }
  public MetaHierarchyList getList() throws PersistenceException{
    if (this.list == null) {
      this.list = ConnectionHandler
                    .getTheConnectionHandler()
                      .theMetaAssociationFacade.hierarchiesGet(this.owner.getId());
    }
    return this.list;
  }
  public Iterator<PersistentMetaHierarchy> iterator() throws PersistenceException{
    return this.getList().iterator(this);
  }
  public long getLength() throws PersistenceException{
	  return this.getList().getLength();
  }
  public void add(PersistentMetaHierarchy entry) throws PersistenceException {
    if (entry != null) {
      MetaHierarchyList list = this.getList();
      long entryId = ConnectionHandler.getTheConnectionHandler().theMetaAssociationFacade
                       .hierarchiesAdd(owner.getId(), entry);
      list.add((PersistentMetaHierarchy)PersistentProxi.createListEntryProxi(entry.getId(),
                               entry.getClassId(),
                               entryId));
      
    }
  }
  protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    ConnectionHandler.getTheConnectionHandler().theMetaAssociationFacade.hierarchiesRem(entry.getListEntryId());
    
  }
  public MetaAssociation_HierarchiesProxi copy(MetaAssociation owner) throws PersistenceException {
  	MetaAssociation_HierarchiesProxi result = new MetaAssociation_HierarchiesProxi(owner);
  	result.list = this.getList().copy();
  	return result;
  } 

}
