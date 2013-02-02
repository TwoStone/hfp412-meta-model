
package model.visitor;

import persistence.MessageManagerCommand;
import persistence.PersistenceException;
import persistence.PersistentCreateConstCommand;
import persistence.PersistentCreateMessageCommand;
import persistence.PersistentCreateStaticMessageCommand;
import persistence.PersistentCreateVoidMessageCommand;
import persistence.PersistentRemoveMessageCommand;

public abstract class MessageManagerCommandStandardVisitor implements MessageManagerCommandVisitor {
    
    public void handleCreateStaticMessageCommand(PersistentCreateStaticMessageCommand createStaticMessageCommand) throws PersistenceException{
        this.standardHandling(createStaticMessageCommand);
    }
    public void handleCreateVoidMessageCommand(PersistentCreateVoidMessageCommand createVoidMessageCommand) throws PersistenceException{
        this.standardHandling(createVoidMessageCommand);
    }
    public void handleRemoveMessageCommand(PersistentRemoveMessageCommand removeMessageCommand) throws PersistenceException{
        this.standardHandling(removeMessageCommand);
    }
    public void handleCreateMessageCommand(PersistentCreateMessageCommand createMessageCommand) throws PersistenceException{
        this.standardHandling(createMessageCommand);
    }
    public void handleCreateConstCommand(PersistentCreateConstCommand createConstCommand) throws PersistenceException{
        this.standardHandling(createConstCommand);
    }
    protected abstract void standardHandling(MessageManagerCommand messageManagerCommand) throws PersistenceException;
}
