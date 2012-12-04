package persistence;

import model.*;

import java.util.Iterator;

public class AssociationManager_AssociationsProxi extends PersistentListProxi<PersistentMAssociation> {

  private MAssociationList list;
  private AssociationManager owner;

  public AssociationManager_AssociationsProxi(AssociationManager owner) {
    this.owner = owner;
  }
  public MAssociationList getList() throws PersistenceException{
    if (this.list == null) {
      if (this.owner.isDelayed$Persistence()) {
        this.list = new MAssociationList();
      } else {
        this.list = ConnectionHandler
                    .getTheConnectionHandler()
                      .theAssociationManagerFacade.associationsGet(this.owner.getId());
      }
    }
    return this.list;
  }
  public Iterator<PersistentMAssociation> iterator() throws PersistenceException{
    return this.getList().iterator(this);
  }
  public long getLength() throws PersistenceException{
	  return this.getList().getLength();
  }
  public void add(PersistentMAssociation entry) throws PersistenceException {
    if (entry != null) {
      MAssociationList list = this.getList();
      long entryId = 0;
      if (!this.owner.isDelayed$Persistence()) {
        entry.store();  	
        entryId = ConnectionHandler.getTheConnectionHandler().theAssociationManagerFacade
                       .associationsAdd(owner.getId(), entry);
      }
      list.add((PersistentMAssociation)PersistentProxi.createListEntryProxi(entry.getId(),
                               entry.getClassId(),
                               entryId));
      
    }
  }
  protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    if (!this.owner.isDelayed$Persistence()) {
      ConnectionHandler.getTheConnectionHandler().theAssociationManagerFacade.associationsRem(entry.getListEntryId());
    }
    
  }
  public AssociationManager_AssociationsProxi copy(AssociationManager owner) throws PersistenceException {
  	AssociationManager_AssociationsProxi result = new AssociationManager_AssociationsProxi(owner);
  	result.list = this.getList().copy();
  	return result;
  } 
  public void store() throws PersistenceException {
  	java.util.Iterator<PersistentMAssociation> entries = (this.list == null ? new java.util.Vector<PersistentMAssociation>().iterator() : this.list.iterator(this));
  	while (entries.hasNext()){
  		PersistentMAssociation current = entries.next();
  		current.store();
      	long entryId = ConnectionHandler.getTheConnectionHandler().theAssociationManagerFacade
                       .associationsAdd(owner.getId(), current);
        ((PersistentListEntryProxi)current).setListEntryId(entryId);
  	}
  }	
}
