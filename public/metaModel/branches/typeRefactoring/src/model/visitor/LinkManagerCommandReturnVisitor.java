
package model.visitor;

import persistence.*;

public interface LinkManagerCommandReturnVisitor<R> {
    
    public R handleRemoveLinkCommand(PersistentRemoveLinkCommand removeLinkCommand) throws PersistenceException;
    public R handleCreateLinkCommand(PersistentCreateLinkCommand createLinkCommand) throws PersistenceException;
    
}
