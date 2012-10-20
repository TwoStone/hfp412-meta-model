package persistence;

import model.*;

import java.util.Iterator;

public class MetaType_SubtypesProxi extends PersistentListProxi<PersistentMetaType> {

  private MetaTypeList list;
  private MetaType owner;

  public MetaType_SubtypesProxi(MetaType owner) {
    this.owner = owner;
  }
  public MetaTypeList getList() throws PersistenceException{
    if (this.list == null) {
      this.list = ConnectionHandler
                    .getTheConnectionHandler()
                      .theMetaTypeFacade.subtypesGet(this.owner.getId());
    }
    return this.list;
  }
  public Iterator<PersistentMetaType> iterator() throws PersistenceException{
    return this.getList().iterator(this);
  }
  public long getLength() throws PersistenceException{
	  return this.getList().getLength();
  }
  public void add(PersistentMetaType entry) throws PersistenceException {
    if (entry != null) {
      MetaTypeList list = this.getList();
      long entryId = ConnectionHandler.getTheConnectionHandler().theMetaTypeFacade
                       .subtypesAdd(owner.getId(), entry);
      list.add((PersistentMetaType)PersistentProxi.createListEntryProxi(entry.getId(),
                               entry.getClassId(),
                               entryId));
      
    }
  }
  protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    ConnectionHandler.getTheConnectionHandler().theMetaTypeFacade.subtypesRem(entry.getListEntryId());
    
  }
  public MetaType_SubtypesProxi copy(MetaType owner) throws PersistenceException {
  	MetaType_SubtypesProxi result = new MetaType_SubtypesProxi(owner);
  	result.list = this.getList().copy();
  	return result;
  } 

}
