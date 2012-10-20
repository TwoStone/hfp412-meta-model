package persistence;

import model.*;

import java.util.Iterator;

public class TypeManager_AllTypesProxi extends PersistentListProxi<PersistentAbstractMetaType> {

  private AbstractMetaTypeList list;
  private TypeManager owner;

  public TypeManager_AllTypesProxi(TypeManager owner) {
    this.owner = owner;
  }
  public AbstractMetaTypeList getList() throws PersistenceException{
    if (this.list == null) {
      this.list = ConnectionHandler
                    .getTheConnectionHandler()
                      .theTypeManagerFacade.allTypesGet(this.owner.getId());
    }
    return this.list;
  }
  public Iterator<PersistentAbstractMetaType> iterator() throws PersistenceException{
    return this.getList().iterator(this);
  }
  public long getLength() throws PersistenceException{
	  return this.getList().getLength();
  }
  public void add(PersistentAbstractMetaType entry) throws PersistenceException {
    if (entry != null) {
      AbstractMetaTypeList list = this.getList();
      long entryId = ConnectionHandler.getTheConnectionHandler().theTypeManagerFacade
                       .allTypesAdd(owner.getId(), entry);
      list.add((PersistentAbstractMetaType)PersistentProxi.createListEntryProxi(entry.getId(),
                               entry.getClassId(),
                               entryId));
      
    }
  }
  protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    ConnectionHandler.getTheConnectionHandler().theTypeManagerFacade.allTypesRem(entry.getListEntryId());
    
  }
  public TypeManager_AllTypesProxi copy(TypeManager owner) throws PersistenceException {
  	TypeManager_AllTypesProxi result = new TypeManager_AllTypesProxi(owner);
  	result.list = this.getList().copy();
  	return result;
  } 

}
