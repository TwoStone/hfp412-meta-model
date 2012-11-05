package persistence;

import model.*;

import java.util.Iterator;

public class MComplexType_ContainedTypesProxi extends PersistentListProxi<MType> {

  private MTypeList list;
  private MComplexType owner;

  public MComplexType_ContainedTypesProxi(MComplexType owner) {
    this.owner = owner;
  }
  public MTypeList getList() throws PersistenceException{
    if (this.list == null) {
      this.list = ConnectionHandler
                    .getTheConnectionHandler()
                      .theMComplexTypeFacade.containedTypesGet(this.owner.getId());
    }
    return this.list;
  }
  public Iterator<MType> iterator() throws PersistenceException{
    return this.getList().iterator(this);
  }
  public long getLength() throws PersistenceException{
	  return this.getList().getLength();
  }
  public void add(MType entry) throws PersistenceException , model.CycleException{
    if (entry != null) {
      if (entry.containsMComplexTypeHierarchy(this.owner)) throw new model.CycleException("Cycle in MComplexTypeHierarchy detected!");
      MTypeList list = this.getList();
      long entryId = ConnectionHandler.getTheConnectionHandler().theMComplexTypeFacade
                       .containedTypesAdd(owner.getId(), entry);
      list.add((MType)PersistentProxi.createListEntryProxi(entry.getId(),
                               entry.getClassId(),
                               entryId));
      
    }
  }
  protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    ConnectionHandler.getTheConnectionHandler().theMComplexTypeFacade.containedTypesRem(entry.getListEntryId());
    
  }
  public MComplexType_ContainedTypesProxi copy(MComplexType owner) throws PersistenceException {
  	MComplexType_ContainedTypesProxi result = new MComplexType_ContainedTypesProxi(owner);
  	result.list = this.getList().copy();
  	return result;
  } 

}
