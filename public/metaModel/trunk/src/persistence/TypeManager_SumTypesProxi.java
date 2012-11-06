package persistence;

import model.*;

import java.util.Iterator;

public class TypeManager_SumTypesProxi extends PersistentListProxi<PersistentMSumType> {

  private MSumTypeList list;
  private TypeManager owner;

  public TypeManager_SumTypesProxi(TypeManager owner) {
    this.owner = owner;
  }
  public MSumTypeList getList() throws PersistenceException{
    if (this.list == null) {
      if (this.owner.isDelayed$Persistence()) {
        this.list = new MSumTypeList();
      } else {
        this.list = ConnectionHandler
                    .getTheConnectionHandler()
                      .theTypeManagerFacade.sumTypesGet(this.owner.getId());
      }
    }
    return this.list;
  }
  public Iterator<PersistentMSumType> iterator() throws PersistenceException{
    return this.getList().iterator(this);
  }
  public long getLength() throws PersistenceException{
	  return this.getList().getLength();
  }
  public void add(PersistentMSumType entry) throws PersistenceException {
    if (entry != null) {
      MSumTypeList list = this.getList();
      long entryId = 0;
      if (!this.owner.isDelayed$Persistence()) {
        entry.store();  	
        entryId = ConnectionHandler.getTheConnectionHandler().theTypeManagerFacade
                       .sumTypesAdd(owner.getId(), entry);
      }
      list.add((PersistentMSumType)PersistentProxi.createListEntryProxi(entry.getId(),
                               entry.getClassId(),
                               entryId));
      
    }
  }
  protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    if (!this.owner.isDelayed$Persistence()) {
      ConnectionHandler.getTheConnectionHandler().theTypeManagerFacade.sumTypesRem(entry.getListEntryId());
    }
    
  }
  public TypeManager_SumTypesProxi copy(TypeManager owner) throws PersistenceException {
  	TypeManager_SumTypesProxi result = new TypeManager_SumTypesProxi(owner);
  	result.list = this.getList().copy();
  	return result;
  } 
  public void store() throws PersistenceException {
  	java.util.Iterator<PersistentMSumType> entries = (this.list == null ? new java.util.Vector<PersistentMSumType>().iterator() : this.list.iterator(this));
  	while (entries.hasNext()){
  		PersistentMSumType current = entries.next();
  		current.store();
      	long entryId = ConnectionHandler.getTheConnectionHandler().theTypeManagerFacade
                       .sumTypesAdd(owner.getId(), current);
        ((PersistentListEntryProxi)current).setListEntryId(entryId);
  	}
  }	
}
