package persistence;

import model.quantity.*;

import java.util.Iterator;

public class CompUnitType_RefsProxi extends PersistentListProxi<PersistentReferenceType> {

  private ReferenceTypeList list;
  private CompUnitType owner;

  public CompUnitType_RefsProxi(CompUnitType owner) {
    this.owner = owner;
  }
  public ReferenceTypeList getList() throws PersistenceException{
    if (this.list == null) {
      if (this.owner.isDelayed$Persistence()) {
        this.list = new ReferenceTypeList();
      } else {
        this.list = ConnectionHandler
                    .getTheConnectionHandler()
                      .theCompUnitTypeFacade.refsGet(this.owner.getId());
      }
    }
    return this.list;
  }
  public Iterator<PersistentReferenceType> iterator() throws PersistenceException{
    return this.getList().iterator(this);
  }
  public long getLength() throws PersistenceException{
	  return this.getList().getLength();
  }
  public void add(PersistentReferenceType entry) throws PersistenceException {
    if (entry != null) {
      ReferenceTypeList list = this.getList();
      long entryId = 0;
      if (!this.owner.isDelayed$Persistence()) {
        entry.store();  	
        entryId = ConnectionHandler.getTheConnectionHandler().theCompUnitTypeFacade
                       .refsAdd(owner.getId(), entry);
      }
      list.add((PersistentReferenceType)PersistentProxi.createListEntryProxi(entry.getId(),
                               entry.getClassId(),
                               entryId));
      
    }
  }
  protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    if (!this.owner.isDelayed$Persistence()) {
      ConnectionHandler.getTheConnectionHandler().theCompUnitTypeFacade.refsRem(entry.getListEntryId());
    }
    
  }
  public CompUnitType_RefsProxi copy(CompUnitType owner) throws PersistenceException {
  	CompUnitType_RefsProxi result = new CompUnitType_RefsProxi(owner);
  	result.list = this.getList().copy();
  	return result;
  } 
  public void store() throws PersistenceException {
  	java.util.Iterator<PersistentReferenceType> entries = (this.list == null ? new java.util.Vector<PersistentReferenceType>().iterator() : this.list.iterator(this));
  	while (entries.hasNext()){
  		PersistentReferenceType current = entries.next();
  		current.store();
      	long entryId = ConnectionHandler.getTheConnectionHandler().theCompUnitTypeFacade
                       .refsAdd(owner.getId(), current);
        ((PersistentListEntryProxi)current).setListEntryId(entryId);
  	}
  }	
}
