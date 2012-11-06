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
      if (this.owner.isDelayed$Persistence()) {
        this.list = new MProductTypeList();
      } else {
        this.list = ConnectionHandler
                    .getTheConnectionHandler()
                      .theTypeManagerFacade.productTypesGet(this.owner.getId());
      }
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
      long entryId = 0;
      if (!this.owner.isDelayed$Persistence()) {
        entry.store();  	
        entryId = ConnectionHandler.getTheConnectionHandler().theTypeManagerFacade
                       .productTypesAdd(owner.getId(), entry);
      }
      list.add((PersistentMProductType)PersistentProxi.createListEntryProxi(entry.getId(),
                               entry.getClassId(),
                               entryId));
      
    }
  }
  protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    if (!this.owner.isDelayed$Persistence()) {
      ConnectionHandler.getTheConnectionHandler().theTypeManagerFacade.productTypesRem(entry.getListEntryId());
    }
    
  }
  public TypeManager_ProductTypesProxi copy(TypeManager owner) throws PersistenceException {
  	TypeManager_ProductTypesProxi result = new TypeManager_ProductTypesProxi(owner);
  	result.list = this.getList().copy();
  	return result;
  } 
  public void store() throws PersistenceException {
  	java.util.Iterator<PersistentMProductType> entries = (this.list == null ? new java.util.Vector<PersistentMProductType>().iterator() : this.list.iterator(this));
  	while (entries.hasNext()){
  		PersistentMProductType current = entries.next();
  		current.store();
      	long entryId = ConnectionHandler.getTheConnectionHandler().theTypeManagerFacade
                       .productTypesAdd(owner.getId(), current);
        ((PersistentListEntryProxi)current).setListEntryId(entryId);
  	}
  }	
}
