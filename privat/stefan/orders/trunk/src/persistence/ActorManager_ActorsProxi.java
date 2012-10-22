package persistence;

import model.*;

import java.util.Iterator;

public class ActorManager_ActorsProxi extends PersistentListProxi<PersistentActor> {

  private ActorList list;
  private ActorManager owner;

  public ActorManager_ActorsProxi(ActorManager owner) {
    this.owner = owner;
  }
  public ActorList getList() throws PersistenceException{
    if (this.list == null) {
      this.list = ConnectionHandler
                    .getTheConnectionHandler()
                      .theActorManagerFacade.actorsGet(this.owner.getId());
    }
    return this.list;
  }
  public Iterator<PersistentActor> iterator() throws PersistenceException{
    return this.getList().iterator(this);
  }
  public long getLength() throws PersistenceException{
	  return this.getList().getLength();
  }
  public void add(PersistentActor entry) throws PersistenceException {
    if (entry != null) {
      ActorList list = this.getList();
      long entryId = ConnectionHandler.getTheConnectionHandler().theActorManagerFacade
                       .actorsAdd(owner.getId(), entry);
      list.add((PersistentActor)PersistentProxi.createListEntryProxi(entry.getId(),
                               entry.getClassId(),
                               entryId));
      
    }
  }
  protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    ConnectionHandler.getTheConnectionHandler().theActorManagerFacade.actorsRem(entry.getListEntryId());
    
  }
  public ActorManager_ActorsProxi copy(ActorManager owner) throws PersistenceException {
  	ActorManager_ActorsProxi result = new ActorManager_ActorsProxi(owner);
  	result.list = this.getList().copy();
  	return result;
  } 

}
