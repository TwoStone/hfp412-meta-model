package persistence;

import model.*;

import java.util.Iterator;

public class TypeManager_AtomicTypesProxi extends PersistentListProxi<PersistentMAtomicType> {

  private MAtomicTypeList list;
  private TypeManager owner;

  public TypeManager_AtomicTypesProxi(TypeManager owner) {
    this.owner = owner;
  }
  public MAtomicTypeList getList() throws PersistenceException{
    if (this.list == null) {
      if (this.owner.isDelayed$Persistence()) {
        this.list = new MAtomicTypeList();
      } else {
        this.list = ConnectionHandler
                    .getTheConnectionHandler()
                      .theTypeManagerFacade.atomicTypesGet(this.owner.getId());
      }
    }
    return this.list;
  }
  public Iterator<PersistentMAtomicType> iterator() throws PersistenceException{
    return this.getList().iterator(this);
  }
  public long getLength() throws PersistenceException{
	  return this.getList().getLength();
  }
  public void add(PersistentMAtomicType entry) throws PersistenceException {
    if (entry != null) {
      MAtomicTypeList list = this.getList();
      long entryId = 0;
      if (!this.owner.isDelayed$Persistence()) {
        entry.store();  	
        entryId = ConnectionHandler.getTheConnectionHandler().theTypeManagerFacade
                       .atomicTypesAdd(owner.getId(), entry);
      }
      list.add((PersistentMAtomicType)PersistentProxi.createListEntryProxi(entry.getId(),
                               entry.getClassId(),
                               entryId));
      
    }
  }
  protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    if (!this.owner.isDelayed$Persistence()) {
      ConnectionHandler.getTheConnectionHandler().theTypeManagerFacade.atomicTypesRem(entry.getListEntryId());
    }
    
  }
  public TypeManager_AtomicTypesProxi copy(TypeManager owner) throws PersistenceException {
  	TypeManager_AtomicTypesProxi result = new TypeManager_AtomicTypesProxi(owner);
  	result.list = this.getList().copy();
  	return result;
  } 
  public void store() throws PersistenceException {
  	java.util.Iterator<PersistentMAtomicType> entries = (this.list == null ? new java.util.Vector<PersistentMAtomicType>().iterator() : this.list.iterator(this));
  	while (entries.hasNext()){
  		PersistentMAtomicType current = entries.next();
  		current.store();
      	long entryId = ConnectionHandler.getTheConnectionHandler().theTypeManagerFacade
                       .atomicTypesAdd(owner.getId(), current);
        ((PersistentListEntryProxi)current).setListEntryId(entryId);
  	}
  }	
}
