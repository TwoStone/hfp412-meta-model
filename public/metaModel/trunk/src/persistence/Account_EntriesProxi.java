package persistence;

import model.measurement.*;

import java.util.Iterator;

public class Account_EntriesProxi extends PersistentListProxi<PersistentMeasurement> {

  private MeasurementList list;
  private Account owner;

  public Account_EntriesProxi(Account owner) {
    this.owner = owner;
  }
  public MeasurementList getList() throws PersistenceException{
    if (this.list == null) {
      if (this.owner.isDelayed$Persistence()) {
        this.list = new MeasurementList();
      } else {
        this.list = ConnectionHandler
                    .getTheConnectionHandler()
                      .theAccountFacade.entriesGet(this.owner.getId());
      }
    }
    return this.list;
  }
  public Iterator<PersistentMeasurement> iterator() throws PersistenceException{
    return this.getList().iterator(this);
  }
  public long getLength() throws PersistenceException{
	  return this.getList().getLength();
  }
  public void add(PersistentMeasurement entry) throws PersistenceException {
    if (entry != null) {
      MeasurementList list = this.getList();
      long entryId = 0;
      if (!this.owner.isDelayed$Persistence()) {
        entry.store();  	
        entryId = ConnectionHandler.getTheConnectionHandler().theAccountFacade
                       .entriesAdd(owner.getId(), entry);
      }
      list.add((PersistentMeasurement)PersistentProxi.createListEntryProxi(entry.getId(),
                               entry.getClassId(),
                               entryId));
      
    }
  }
  protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    if (!this.owner.isDelayed$Persistence()) {
      ConnectionHandler.getTheConnectionHandler().theAccountFacade.entriesRem(entry.getListEntryId());
    }
    
  }
  public Account_EntriesProxi copy(Account owner) throws PersistenceException {
  	Account_EntriesProxi result = new Account_EntriesProxi(owner);
  	result.list = this.getList().copy();
  	return result;
  } 
  public void store() throws PersistenceException {
  	java.util.Iterator<PersistentMeasurement> entries = (this.list == null ? new java.util.Vector<PersistentMeasurement>().iterator() : this.list.iterator(this));
  	while (entries.hasNext()){
  		PersistentMeasurement current = entries.next();
  		current.store();
      	long entryId = ConnectionHandler.getTheConnectionHandler().theAccountFacade
                       .entriesAdd(owner.getId(), current);
        ((PersistentListEntryProxi)current).setListEntryId(entryId);
  	}
  }	
}
