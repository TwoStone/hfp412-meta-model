
package model.visitor;

import persistence.*;

public interface MessageManagerCommandVisitor {
    
    public void handleCreateMessageCommand(PersistentCreateMessageCommand createMessageCommand) throws PersistenceException;
    public void handleCreateStaticMessageCommand(PersistentCreateStaticMessageCommand createStaticMessageCommand) throws PersistenceException;
    public void handleCreateVoidMessageCommand(PersistentCreateVoidMessageCommand createVoidMessageCommand) throws PersistenceException;
    public void handleCreateConstCommand(PersistentCreateConstCommand createConstCommand) throws PersistenceException;
    public void handleRemoveMessageCommand(PersistentRemoveMessageCommand removeMessageCommand) throws PersistenceException;
    
}
