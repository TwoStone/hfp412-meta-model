package persistence;

import model.*;

import java.util.Iterator;

public class CompUnit_RefsProxi extends PersistentListProxi<PersistentReference> {

  private ReferenceList list;
  private CompUnit owner;

  public CompUnit_RefsProxi(CompUnit owner) {
    this.owner = owner;
  }
  public ReferenceList getList() throws PersistenceException{
    if (this.list == null) {
      if (this.owner.isDelayed$Persistence()) {
        this.list = new ReferenceList();
      } else {
        this.list = ConnectionHandler
                    .getTheConnectionHandler()
                      .theCompUnitFacade.refsGet(this.owner.getId());
      }
    }
    return this.list;
  }
  public Iterator<PersistentReference> iterator() throws PersistenceException{
    return this.getList().iterator(this);
  }
  public long getLength() throws PersistenceException{
	  return this.getList().getLength();
  }
  public void add(PersistentReference entry) throws PersistenceException {
    if (entry != null) {
      ReferenceList list = this.getList();
      long entryId = 0;
      if (!this.owner.isDelayed$Persistence()) {
        entry.store();  	
        entryId = ConnectionHandler.getTheConnectionHandler().theCompUnitFacade
                       .refsAdd(owner.getId(), entry);
      }
      list.add((PersistentReference)PersistentProxi.createListEntryProxi(entry.getId(),
                               entry.getClassId(),
                               entryId));
      
    }
  }
  protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    if (!this.owner.isDelayed$Persistence()) {
      ConnectionHandler.getTheConnectionHandler().theCompUnitFacade.refsRem(entry.getListEntryId());
    }
    
  }
  public CompUnit_RefsProxi copy(CompUnit owner) throws PersistenceException {
  	CompUnit_RefsProxi result = new CompUnit_RefsProxi(owner);
  	result.list = this.getList().copy();
  	return result;
  } 
  public void store() throws PersistenceException {
  	java.util.Iterator<PersistentReference> entries = (this.list == null ? new java.util.Vector<PersistentReference>().iterator() : this.list.iterator(this));
  	while (entries.hasNext()){
  		PersistentReference current = entries.next();
  		current.store();
      	long entryId = ConnectionHandler.getTheConnectionHandler().theCompUnitFacade
                       .refsAdd(owner.getId(), current);
        ((PersistentListEntryProxi)current).setListEntryId(entryId);
  	}
  }	
}
