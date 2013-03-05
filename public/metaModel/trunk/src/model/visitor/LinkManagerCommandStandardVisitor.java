
package model.visitor;

import persistence.*;

public abstract class LinkManagerCommandStandardVisitor implements LinkManagerCommandVisitor {
    
    public void handleCreateLinkCommand(PersistentCreateLinkCommand createLinkCommand) throws PersistenceException{
        this.standardHandling(createLinkCommand);
    }
    public void handleRemoveLinkCommand(PersistentRemoveLinkCommand removeLinkCommand) throws PersistenceException{
        this.standardHandling(removeLinkCommand);
    }
    protected abstract void standardHandling(LinkManagerCommand linkManagerCommand) throws PersistenceException;
}
