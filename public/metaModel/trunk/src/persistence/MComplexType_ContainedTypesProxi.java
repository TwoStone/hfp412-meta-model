package persistence;

import model.typeSystem.*;

import java.util.Iterator;

public class MComplexType_ContainedTypesProxi extends PersistentListProxi<PersistentMType> {

  private MTypeList list;
  private MComplexType owner;

  public MComplexType_ContainedTypesProxi(MComplexType owner) {
    this.owner = owner;
  }
  public MTypeList getList() throws PersistenceException{
    if (this.list == null) {
      if (this.owner.isDelayed$Persistence()) {
        this.list = new MTypeList();
      } else {
        this.list = ConnectionHandler
                    .getTheConnectionHandler()
                      .theMComplexTypeFacade.containedTypesGet(this.owner.getId());
      }
    }
    return this.list;
  }
  public Iterator<PersistentMType> iterator() throws PersistenceException{
    return this.getList().iterator(this);
  }
  public long getLength() throws PersistenceException{
	  return this.getList().getLength();
  }
  public void add(PersistentMType entry) throws PersistenceException , model.CycleException{
    if (entry != null) {
      if (entry.containsMComplexTypeHierarchy(this.owner)) throw new model.CycleException("Cycle in MComplexTypeHierarchy detected!");
      MTypeList list = this.getList();
      long entryId = 0;
      if (!this.owner.isDelayed$Persistence()) {
        entry.store();  	
        entryId = ConnectionHandler.getTheConnectionHandler().theMComplexTypeFacade
                       .containedTypesAdd(owner.getId(), entry);
      }
      list.add((PersistentMType)PersistentProxi.createListEntryProxi(entry.getId(),
                               entry.getClassId(),
                               entryId));
      
    }
  }
  protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    if (!this.owner.isDelayed$Persistence()) {
      ConnectionHandler.getTheConnectionHandler().theMComplexTypeFacade.containedTypesRem(entry.getListEntryId());
    }
    
  }
  public MComplexType_ContainedTypesProxi copy(MComplexType owner) throws PersistenceException {
  	MComplexType_ContainedTypesProxi result = new MComplexType_ContainedTypesProxi(owner);
  	result.list = this.getList().copy();
  	return result;
  } 
  public void store() throws PersistenceException {
  	java.util.Iterator<PersistentMType> entries = (this.list == null ? new java.util.Vector<PersistentMType>().iterator() : this.list.iterator(this));
  	while (entries.hasNext()){
  		PersistentMType current = entries.next();
  		current.store();
      	long entryId = ConnectionHandler.getTheConnectionHandler().theMComplexTypeFacade
                       .containedTypesAdd(owner.getId(), current);
        ((PersistentListEntryProxi)current).setListEntryId(entryId);
  	}
  }	
}
