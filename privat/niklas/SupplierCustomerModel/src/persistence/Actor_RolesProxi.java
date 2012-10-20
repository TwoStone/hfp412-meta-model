package persistence;

import model.*;

import java.util.Iterator;

public class Actor_RolesProxi extends PersistentListProxi<PersistentRole> {

  private RoleList list;
  private Actor owner;

  public Actor_RolesProxi(Actor owner) {
    this.owner = owner;
  }
  public RoleList getList() throws PersistenceException{
    if (this.list == null) {
      this.list = ConnectionHandler
                    .getTheConnectionHandler()
                      .theActorFacade.rolesGet(this.owner.getId());
    }
    return this.list;
  }
  public Iterator<PersistentRole> iterator() throws PersistenceException{
    return this.getList().iterator(this);
  }
  public long getLength() throws PersistenceException{
	  return this.getList().getLength();
  }
  public void add(PersistentRole entry) throws PersistenceException {
    if (entry != null) {
      RoleList list = this.getList();
      long entryId = ConnectionHandler.getTheConnectionHandler().theActorFacade
                       .rolesAdd(owner.getId(), entry);
      list.add((PersistentRole)PersistentProxi.createListEntryProxi(entry.getId(),
                               entry.getClassId(),
                               entryId));
      
    }
  }
  protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    ConnectionHandler.getTheConnectionHandler().theActorFacade.rolesRem(entry.getListEntryId());
    
  }
  public Actor_RolesProxi copy(Actor owner) throws PersistenceException {
  	Actor_RolesProxi result = new Actor_RolesProxi(owner);
  	result.list = this.getList().copy();
  	return result;
  } 

}
