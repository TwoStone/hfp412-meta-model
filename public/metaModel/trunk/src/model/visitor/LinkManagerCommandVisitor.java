
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentCreateLinkCommand;
import persistence.PersistentRemoveLinkCommand;

public interface LinkManagerCommandVisitor {
    
    public void handleRemoveLinkCommand(PersistentRemoveLinkCommand removeLinkCommand) throws PersistenceException;
    public void handleCreateLinkCommand(PersistentCreateLinkCommand createLinkCommand) throws PersistenceException;
    
}
