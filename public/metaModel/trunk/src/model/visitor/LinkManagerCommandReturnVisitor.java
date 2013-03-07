
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentCreateLinkCommand;
import persistence.PersistentRemoveLinkCommand;

public interface LinkManagerCommandReturnVisitor<R> {
    
    public R handleRemoveLinkCommand(PersistentRemoveLinkCommand removeLinkCommand) throws PersistenceException;
    public R handleCreateLinkCommand(PersistentCreateLinkCommand createLinkCommand) throws PersistenceException;
    
}
