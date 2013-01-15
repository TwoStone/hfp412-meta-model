package persistence;

import model.measurement.*;

import java.util.Iterator;

public class MAccountType_SubAccountTypesProxi extends PersistentListProxi<PersistentMAccountType> {

  private MAccountTypeList list;
  private MAccountType owner;

  public MAccountType_SubAccountTypesProxi(MAccountType owner) {
    this.owner = owner;
  }
  public MAccountTypeList getList() throws PersistenceException{
    if (this.list == null) {
      if (this.owner.isDelayed$Persistence()) {
        this.list = new MAccountTypeList();
      } else {
        this.list = ConnectionHandler
                    .getTheConnectionHandler()
                      .theMAccountTypeFacade.subAccountTypesGet(this.owner.getId());
      }
    }
    return this.list;
  }
  public Iterator<PersistentMAccountType> iterator() throws PersistenceException{
    return this.getList().iterator(this);
  }
  public long getLength() throws PersistenceException{
	  return this.getList().getLength();
  }
  public void add(PersistentMAccountType entry) throws PersistenceException , model.CycleException{
    if (entry != null) {
      if (entry.containsMAccountTypeHierarchy(this.owner)) throw new model.CycleException("Cycle in MAccountTypeHierarchy detected!");
      MAccountTypeList list = this.getList();
      long entryId = 0;
      if (!this.owner.isDelayed$Persistence()) {
        entry.store();  	
        entryId = ConnectionHandler.getTheConnectionHandler().theMAccountTypeFacade
                       .subAccountTypesAdd(owner.getId(), entry);
      }
      list.add((PersistentMAccountType)PersistentProxi.createListEntryProxi(entry.getId(),
                               entry.getClassId(),
                               entryId));
      
    }
  }
  protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    if (!this.owner.isDelayed$Persistence()) {
      ConnectionHandler.getTheConnectionHandler().theMAccountTypeFacade.subAccountTypesRem(entry.getListEntryId());
    }
    
  }
  public MAccountType_SubAccountTypesProxi copy(MAccountType owner) throws PersistenceException {
  	MAccountType_SubAccountTypesProxi result = new MAccountType_SubAccountTypesProxi(owner);
  	result.list = this.getList().copy();
  	return result;
  } 
  public void store() throws PersistenceException {
  	java.util.Iterator<PersistentMAccountType> entries = (this.list == null ? new java.util.Vector<PersistentMAccountType>().iterator() : this.list.iterator(this));
  	while (entries.hasNext()){
  		PersistentMAccountType current = entries.next();
  		current.store();
      	long entryId = ConnectionHandler.getTheConnectionHandler().theMAccountTypeFacade
                       .subAccountTypesAdd(owner.getId(), current);
        ((PersistentListEntryProxi)current).setListEntryId(entryId);
  	}
  }	
}
