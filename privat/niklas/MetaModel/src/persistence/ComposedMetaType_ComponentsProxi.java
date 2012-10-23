package persistence;

import model.*;

import java.util.Iterator;

public class ComposedMetaType_ComponentsProxi extends PersistentListProxi<PersistentAbstractMetaType> {

  private AbstractMetaTypeList list;
  private ComposedMetaType owner;

  public ComposedMetaType_ComponentsProxi(ComposedMetaType owner) {
    this.owner = owner;
  }
  public AbstractMetaTypeList getList() throws PersistenceException{
    if (this.list == null) {
      this.list = ConnectionHandler
                    .getTheConnectionHandler()
                      .theComposedMetaTypeFacade.componentsGet(this.owner.getId());
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
      long entryId = ConnectionHandler.getTheConnectionHandler().theComposedMetaTypeFacade
                       .componentsAdd(owner.getId(), entry);
      list.add((PersistentAbstractMetaType)PersistentProxi.createListEntryProxi(entry.getId(),
                               entry.getClassId(),
                               entryId));
      
    }
  }
  protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    ConnectionHandler.getTheConnectionHandler().theComposedMetaTypeFacade.componentsRem(entry.getListEntryId());
    
  }
  public ComposedMetaType_ComponentsProxi copy(ComposedMetaType owner) throws PersistenceException {
  	ComposedMetaType_ComponentsProxi result = new ComposedMetaType_ComponentsProxi(owner);
  	result.list = this.getList().copy();
  	return result;
  } 

}
