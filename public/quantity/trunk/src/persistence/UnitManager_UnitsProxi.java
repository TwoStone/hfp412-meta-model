package persistence;

import model.*;

import java.util.Iterator;

public class UnitManager_UnitsProxi extends PersistentListProxi<PersistentAbsUnit> {

  private AbsUnitList list;
  private UnitManager owner;

  public UnitManager_UnitsProxi(UnitManager owner) {
    this.owner = owner;
  }
  public AbsUnitList getList() throws PersistenceException{
    if (this.list == null) {
      this.list = ConnectionHandler
                    .getTheConnectionHandler()
                      .theUnitManagerFacade.unitsGet(this.owner.getId());
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
      long entryId = ConnectionHandler.getTheConnectionHandler().theUnitManagerFacade
                       .unitsAdd(owner.getId(), entry);
      list.add((PersistentAbsUnit)PersistentProxi.createListEntryProxi(entry.getId(),
                               entry.getClassId(),
                               entryId));
      
    }
  }
  protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    ConnectionHandler.getTheConnectionHandler().theUnitManagerFacade.unitsRem(entry.getListEntryId());
    
  }
  public UnitManager_UnitsProxi copy(UnitManager owner) throws PersistenceException {
  	UnitManager_UnitsProxi result = new UnitManager_UnitsProxi(owner);
  	result.list = this.getList().copy();
  	return result;
  } 

}
