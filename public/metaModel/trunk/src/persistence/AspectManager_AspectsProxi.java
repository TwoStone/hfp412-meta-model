package persistence;

import model.*;

import java.util.Iterator;

public class AspectManager_AspectsProxi extends PersistentListProxi<PersistentMAspect> {

  private MAspectList list;
  private AspectManager owner;

  public AspectManager_AspectsProxi(AspectManager owner) {
    this.owner = owner;
  }
  public MAspectList getList() throws PersistenceException{
    if (this.list == null) {
      this.list = ConnectionHandler
                    .getTheConnectionHandler()
                      .theAspectManagerFacade.aspectsGet(this.owner.getId());
    }
    return this.list;
  }
  public Iterator<PersistentMAspect> iterator() throws PersistenceException{
    return this.getList().iterator(this);
  }
  public long getLength() throws PersistenceException{
	  return this.getList().getLength();
  }
  public void add(PersistentMAspect entry) throws PersistenceException {
    if (entry != null) {
      MAspectList list = this.getList();
      long entryId = ConnectionHandler.getTheConnectionHandler().theAspectManagerFacade
                       .aspectsAdd(owner.getId(), entry);
      list.add((PersistentMAspect)PersistentProxi.createListEntryProxi(entry.getId(),
                               entry.getClassId(),
                               entryId));
      
    }
  }
  protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    ConnectionHandler.getTheConnectionHandler().theAspectManagerFacade.aspectsRem(entry.getListEntryId());
    
  }
  public AspectManager_AspectsProxi copy(AspectManager owner) throws PersistenceException {
  	AspectManager_AspectsProxi result = new AspectManager_AspectsProxi(owner);
  	result.list = this.getList().copy();
  	return result;
  } 

}
