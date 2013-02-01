
package model.visitor;
import model.UserException;
import persistence.*;

public interface MessageManagerCommandReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleCreateMessageCommand(PersistentCreateMessageCommand createMessageCommand) throws PersistenceException, E;
    public R handleCreateStaticMessageCommand(PersistentCreateStaticMessageCommand createStaticMessageCommand) throws PersistenceException, E;
    public R handleCreateVoidMessageCommand(PersistentCreateVoidMessageCommand createVoidMessageCommand) throws PersistenceException, E;
    public R handleCreateConstCommand(PersistentCreateConstCommand createConstCommand) throws PersistenceException, E;
    public R handleRemoveMessageCommand(PersistentRemoveMessageCommand removeMessageCommand) throws PersistenceException, E;
    
}
