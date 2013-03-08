
package model.visitor;

import persistence.*;

public abstract class ObsTypeManagerCommandStandardVisitor implements ObsTypeManagerCommandVisitor {
    
    public void handleCreateObsTypeCommand(PersistentCreateObsTypeCommand createObsTypeCommand) throws PersistenceException{
        this.standardHandling(createObsTypeCommand);
    }
    public void handleDeleteObsTypeCommand(PersistentDeleteObsTypeCommand deleteObsTypeCommand) throws PersistenceException{
        this.standardHandling(deleteObsTypeCommand);
    }
    protected abstract void standardHandling(ObsTypeManagerCommand obsTypeManagerCommand) throws PersistenceException;
}
