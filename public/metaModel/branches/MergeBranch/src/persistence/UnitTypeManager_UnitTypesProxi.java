package persistence;

import model.quantity.*;

import java.util.Iterator;

public class UnitTypeManager_UnitTypesProxi extends PersistentListProxi<PersistentAbsUnitType> {

  private AbsUnitTypeList list;
  private UnitTypeManager owner;

  public UnitTypeManager_UnitTypesProxi(UnitTypeManager owner) {
    this.owner = owner;
  }
  public AbsUnitTypeList getList() throws PersistenceException{
    if (this.list == null) {
      if (this.owner.isDelayed$Persistence()) {
        this.list = new AbsUnitTypeList();
      } else {
        this.list = ConnectionHandler
                    .getTheConnectionHandler()
                      .theUnitTypeManagerFacade.unitTypesGet(this.owner.getId());
      }
    }
    return this.list;
  }
  public Iterator<PersistentAbsUnitType> iterator() throws PersistenceException{
    return this.getList().iterator(this);
  }
  public long getLength() throws PersistenceException{
	  return this.getList().getLength();
  }
  public void add(PersistentAbsUnitType entry) throws PersistenceException {
    if (entry != null) {
      AbsUnitTypeList list = this.getList();
      long entryId = 0;
      if (!this.owner.isDelayed$Persistence()) {
        entry.store();  	
        entryId = ConnectionHandler.getTheConnectionHandler().theUnitTypeManagerFacade
                       .unitTypesAdd(owner.getId(), entry);
      }
      list.add((PersistentAbsUnitType)PersistentProxi.createListEntryProxi(entry.getId(),
                               entry.getClassId(),
                               entryId));
      
    }
  }
  protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    if (!this.owner.isDelayed$Persistence()) {
      ConnectionHandler.getTheConnectionHandler().theUnitTypeManagerFacade.unitTypesRem(entry.getListEntryId());
    }
    
  }
  public UnitTypeManager_UnitTypesProxi copy(UnitTypeManager owner) throws PersistenceException {
  	UnitTypeManager_UnitTypesProxi result = new UnitTypeManager_UnitTypesProxi(owner);
  	result.list = this.getList().copy();
  	return result;
  } 
  public void store() throws PersistenceException {
  	java.util.Iterator<PersistentAbsUnitType> entries = (this.list == null ? new java.util.Vector<PersistentAbsUnitType>().iterator() : this.list.iterator(this));
  	while (entries.hasNext()){
  		PersistentAbsUnitType current = entries.next();
  		current.store();
      	long entryId = ConnectionHandler.getTheConnectionHandler().theUnitTypeManagerFacade
                       .unitTypesAdd(owner.getId(), current);
        ((PersistentListEntryProxi)current).setListEntryId(entryId);
  	}
  }	
}
