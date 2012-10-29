
package model.visitor;

import persistence.*;

public abstract class AspectManagerCommandStandardVisitor implements AspectManagerCommandVisitor {
    
    public void handleAddAspectCommand(PersistentAddAspectCommand addAspectCommand) throws PersistenceException{
        this.standardHandling(addAspectCommand);
    }
    protected abstract void standardHandling(AspectManagerCommand aspectManagerCommand) throws PersistenceException;
}
