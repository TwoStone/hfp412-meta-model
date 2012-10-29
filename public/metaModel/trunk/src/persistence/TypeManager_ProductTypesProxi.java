package persistence;

import model.*;

import java.util.Iterator;

public class TypeManager_ProductTypesProxi extends PersistentListProxi<PersistentMProductType> {

  private MProductTypeList list;
  private TypeManager owner;

  public TypeManager_ProductTypesProxi(TypeManager owner) {
    this.owner = owner;
  }
  public MProductTypeList getList() throws PersistenceException{
    if (this.list == null) {
      this.list = ConnectionHandler
                    .getTheConnectionHandler()
                      .theTypeManagerFacade.productTypesGet(this.owner.getId());
    }
    return this.list;
  }
  public Iterator<PersistentMProductType> iterator() throws PersistenceException{
    return this.getList().iterator(this);
  }
  public long getLength() throws PersistenceException{
	  return this.getList().getLength();
  }
  public void add(PersistentMProductType entry) throws PersistenceException {
    if (entry != null) {
      MProductTypeList list = this.getList();
      long entryId = ConnectionHandler.getTheConnectionHandler().theTypeManagerFacade
                       .productTypesAdd(owner.getId(), entry);
      list.add((PersistentMProductType)PersistentProxi.createListEntryProxi(entry.getId(),
                               entry.getClassId(),
                               entryId));
      
    }
  }
  protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    ConnectionHandler.getTheConnectionHandler().theTypeManagerFacade.productTypesRem(entry.getListEntryId());
    
  }
  public TypeManager_ProductTypesProxi copy(TypeManager owner) throws PersistenceException {
  	TypeManager_ProductTypesProxi result = new TypeManager_ProductTypesProxi(owner);
  	result.list = this.getList().copy();
  	return result;
  } 

}
