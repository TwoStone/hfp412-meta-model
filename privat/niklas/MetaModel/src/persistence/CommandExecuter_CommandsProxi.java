package persistence;

import model.meta.*;

import java.util.Iterator;

public class CommandExecuter_CommandsProxi extends PersistentListProxi<Command> {

  private CommandList list;
  private CommandExecuter owner;

  public CommandExecuter_CommandsProxi(CommandExecuter owner) {
    this.owner = owner;
  }
  public CommandList getList() throws PersistenceException{
    if (this.list == null) {
      this.list = ConnectionHandler
                    .getTheConnectionHandler()
                      .theCommandExecuterFacade.commandsGet(this.owner.getId());
    }
    return this.list;
  }
  public Iterator<Command> iterator() throws PersistenceException{
    return this.getList().iterator(this);
  }
  public long getLength() throws PersistenceException{
	  return this.getList().getLength();
  }
  public void add(Command entry) throws PersistenceException {
    if (entry != null) {
      CommandList list = this.getList();
      long entryId = ConnectionHandler.getTheConnectionHandler().theCommandExecuterFacade
                       .commandsAdd(owner.getId(), entry);
      list.add((Command)PersistentProxi.createListEntryProxi(entry.getId(),
                               entry.getClassId(),
                               entryId));
      
    }
  }
  protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    ConnectionHandler.getTheConnectionHandler().theCommandExecuterFacade.commandsRem(entry.getListEntryId());
    
  }
  public CommandExecuter_CommandsProxi copy(CommandExecuter owner) throws PersistenceException {
  	CommandExecuter_CommandsProxi result = new CommandExecuter_CommandsProxi(owner);
  	result.list = this.getList().copy();
  	return result;
  } 

}
