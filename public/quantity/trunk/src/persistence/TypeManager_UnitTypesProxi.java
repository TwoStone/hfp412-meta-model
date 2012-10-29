package persistence;

import model.*;

import java.util.Iterator;

public class TypeManager_UnitTypesProxi extends PersistentListProxi<PersistentAbsUnitType> {

  private AbsUnitTypeList list;
  private TypeManager owner;

  public TypeManager_UnitTypesProxi(TypeManager owner) {
    this.owner = owner;
  }
  public AbsUnitTypeList getList() throws PersistenceException{
    if (this.list == null) {
      this.list = ConnectionHandler
                    .getTheConnectionHandler()
                      .theTypeManagerFacade.unitTypesGet(this.owner.getId());
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
      long entryId = ConnectionHandler.getTheConnectionHandler().theTypeManagerFacade
                       .unitTypesAdd(owner.getId(), entry);
      list.add((PersistentAbsUnitType)PersistentProxi.createListEntryProxi(entry.getId(),
                               entry.getClassId(),
                               entryId));
      
    }
  }
  protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    ConnectionHandler.getTheConnectionHandler().theTypeManagerFacade.unitTypesRem(entry.getListEntryId());
    
  }
  public TypeManager_UnitTypesProxi copy(TypeManager owner) throws PersistenceException {
  	TypeManager_UnitTypesProxi result = new TypeManager_UnitTypesProxi(owner);
  	result.list = this.getList().copy();
  	return result;
  } 

}
