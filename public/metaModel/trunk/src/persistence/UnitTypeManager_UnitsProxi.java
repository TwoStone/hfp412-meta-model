package persistence;

import model.quantity.*;

import java.util.Iterator;

public class UnitTypeManager_UnitsProxi extends PersistentListProxi<PersistentAbsUnit> {

  private AbsUnitList list;
  private UnitTypeManager owner;

  public UnitTypeManager_UnitsProxi(UnitTypeManager owner) {
    this.owner = owner;
  }
  public AbsUnitList getList() throws PersistenceException{
    if (this.list == null) {
      if (this.owner.isDelayed$Persistence()) {
        this.list = new AbsUnitList();
      } else {
        this.list = ConnectionHandler
                    .getTheConnectionHandler()
                      .theUnitTypeManagerFacade.unitsGet(this.owner.getId());
      }
    }
    return this.list;
  }
  public Iterator<PersistentAbsUnit> iterator() throws PersistenceException{
    return this.getList().iterator(this);
  }
  public long getLength() throws PersistenceException{
	  return this.getList().getLength();
  }
  public void add(PersistentAbsUnit entry) throws PersistenceException {
    if (entry != null) {
      AbsUnitList list = this.getList();
      long entryId = 0;
      if (!this.owner.isDelayed$Persistence()) {
        entry.store();  	
        entryId = ConnectionHandler.getTheConnectionHandler().theUnitTypeManagerFacade
                       .unitsAdd(owner.getId(), entry);
      }
      list.add((PersistentAbsUnit)PersistentProxi.createListEntryProxi(entry.getId(),
                               entry.getClassId(),
                               entryId));
      
    }
  }
  protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    if (!this.owner.isDelayed$Persistence()) {
      ConnectionHandler.getTheConnectionHandler().theUnitTypeManagerFacade.unitsRem(entry.getListEntryId());
    }
    
  }
  public UnitTypeManager_UnitsProxi copy(UnitTypeManager owner) throws PersistenceException {
  	UnitTypeManager_UnitsProxi result = new UnitTypeManager_UnitsProxi(owner);
  	result.list = this.getList().copy();
  	return result;
  } 
  public void store() throws PersistenceException {
  	java.util.Iterator<PersistentAbsUnit> entries = (this.list == null ? new java.util.Vector<PersistentAbsUnit>().iterator() : this.list.iterator(this));
  	while (entries.hasNext()){
  		PersistentAbsUnit current = entries.next();
  		current.store();
      	long entryId = ConnectionHandler.getTheConnectionHandler().theUnitTypeManagerFacade
                       .unitsAdd(owner.getId(), current);
        ((PersistentListEntryProxi)current).setListEntryId(entryId);
  	}
  }	
}
