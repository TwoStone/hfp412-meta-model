
package model.visitor;

import persistence.*;

public abstract class AspectManagerCommandStandardVisitor implements AspectManagerCommandVisitor {
    
    public void handleCreateAspectCommand(PersistentCreateAspectCommand createAspectCommand) throws PersistenceException{
        this.standardHandling(createAspectCommand);
    }
    protected abstract void standardHandling(AspectManagerCommand aspectManagerCommand) throws PersistenceException;
}
