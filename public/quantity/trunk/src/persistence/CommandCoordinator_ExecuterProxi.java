package persistence;

import model.meta.*;

import java.util.Iterator;

public class CommandCoordinator_ExecuterProxi extends PersistentListProxi<PersistentCommandExecuter> {

  private CommandExecuterList list;
  private CommandCoordinator owner;

  public CommandCoordinator_ExecuterProxi(CommandCoordinator owner) {
    this.owner = owner;
  }
  public CommandExecuterList getList() throws PersistenceException{
    if (this.list == null) {
      if (this.owner.isDelayed$Persistence()) {
        this.list = new CommandExecuterList();
      } else {
        this.list = ConnectionHandler
                    .getTheConnectionHandler()
                      .theCommandCoordinatorFacade.executerGet(this.owner.getId());
      }
    }
    return this.list;
  }
  public Iterator<PersistentCommandExecuter> iterator() throws PersistenceException{
    return this.getList().iterator(this);
  }
  public long getLength() throws PersistenceException{
	  return this.getList().getLength();
  }
  public void add(PersistentCommandExecuter entry) throws PersistenceException {
    if (entry != null) {
      CommandExecuterList list = this.getList();
      long entryId = 0;
      if (!this.owner.isDelayed$Persistence()) {
        entry.store();  	
        entryId = ConnectionHandler.getTheConnectionHandler().theCommandCoordinatorFacade
                       .executerAdd(owner.getId(), entry);
      }
      list.add((PersistentCommandExecuter)PersistentProxi.createListEntryProxi(entry.getId(),
                               entry.getClassId(),
                               entryId));
      
    }
  }
  protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    if (!this.owner.isDelayed$Persistence()) {
      ConnectionHandler.getTheConnectionHandler().theCommandCoordinatorFacade.executerRem(entry.getListEntryId());
    }
    
  }
  public CommandCoordinator_ExecuterProxi copy(CommandCoordinator owner) throws PersistenceException {
  	CommandCoordinator_ExecuterProxi result = new CommandCoordinator_ExecuterProxi(owner);
  	result.list = this.getList().copy();
  	return result;
  } 
  public void store() throws PersistenceException {
  	java.util.Iterator<PersistentCommandExecuter> entries = (this.list == null ? new java.util.Vector<PersistentCommandExecuter>().iterator() : this.list.iterator(this));
  	while (entries.hasNext()){
  		PersistentCommandExecuter current = entries.next();
  		current.store();
      	long entryId = ConnectionHandler.getTheConnectionHandler().theCommandCoordinatorFacade
                       .executerAdd(owner.getId(), current);
        ((PersistentListEntryProxi)current).setListEntryId(entryId);
  	}
  }	
}
