
package model.visitor;
import model.UserException;
import persistence.*;

public interface MessageManagerCommandExceptionVisitor<E extends UserException> {
    
    public void handleCreateMessageCommand(PersistentCreateMessageCommand createMessageCommand) throws PersistenceException, E;
    public void handleCreateStaticMessageCommand(PersistentCreateStaticMessageCommand createStaticMessageCommand) throws PersistenceException, E;
    public void handleCreateVoidMessageCommand(PersistentCreateVoidMessageCommand createVoidMessageCommand) throws PersistenceException, E;
    public void handleCreateConstCommand(PersistentCreateConstCommand createConstCommand) throws PersistenceException, E;
    public void handleRemoveMessageCommand(PersistentRemoveMessageCommand removeMessageCommand) throws PersistenceException, E;
    
}
