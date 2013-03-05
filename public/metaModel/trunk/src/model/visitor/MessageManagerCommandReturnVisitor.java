
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentCreateConstCommand;
import persistence.PersistentCreateMessageCommand;
import persistence.PersistentCreateStaticMessageCommand;
import persistence.PersistentCreateVoidMessageCommand;
import persistence.PersistentRemoveMessageCommand;

public interface MessageManagerCommandReturnVisitor<R> {
    
    public R handleCreateMessageCommand(PersistentCreateMessageCommand createMessageCommand) throws PersistenceException;
    public R handleCreateStaticMessageCommand(PersistentCreateStaticMessageCommand createStaticMessageCommand) throws PersistenceException;
    public R handleCreateVoidMessageCommand(PersistentCreateVoidMessageCommand createVoidMessageCommand) throws PersistenceException;
    public R handleCreateConstCommand(PersistentCreateConstCommand createConstCommand) throws PersistenceException;
    public R handleRemoveMessageCommand(PersistentRemoveMessageCommand removeMessageCommand) throws PersistenceException;
    
}
