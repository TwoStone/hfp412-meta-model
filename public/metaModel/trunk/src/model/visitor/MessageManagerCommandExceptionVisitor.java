
package model.visitor;
import model.UserException;
import persistence.PersistenceException;
import persistence.PersistentCreateConstCommand;
import persistence.PersistentCreateMessageCommand;
import persistence.PersistentCreateStaticMessageCommand;
import persistence.PersistentCreateVoidMessageCommand;
import persistence.PersistentRemoveMessageCommand;

public interface MessageManagerCommandExceptionVisitor<E extends UserException> {
    
    public void handleCreateMessageCommand(PersistentCreateMessageCommand createMessageCommand) throws PersistenceException, E;
    public void handleCreateStaticMessageCommand(PersistentCreateStaticMessageCommand createStaticMessageCommand) throws PersistenceException, E;
    public void handleCreateVoidMessageCommand(PersistentCreateVoidMessageCommand createVoidMessageCommand) throws PersistenceException, E;
    public void handleCreateConstCommand(PersistentCreateConstCommand createConstCommand) throws PersistenceException, E;
    public void handleRemoveMessageCommand(PersistentRemoveMessageCommand removeMessageCommand) throws PersistenceException, E;
    
}
