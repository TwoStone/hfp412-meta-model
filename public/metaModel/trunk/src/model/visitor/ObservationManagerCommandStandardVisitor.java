
package model.visitor;

import persistence.*;

public abstract class ObservationManagerCommandStandardVisitor implements ObservationManagerCommandVisitor {
    
    public void handleDeleteObservationCommand(PersistentDeleteObservationCommand deleteObservationCommand) throws PersistenceException{
        this.standardHandling(deleteObservationCommand);
    }
    public void handleCreateObservationCommand(PersistentCreateObservationCommand createObservationCommand) throws PersistenceException{
        this.standardHandling(createObservationCommand);
    }
    protected abstract void standardHandling(ObservationManagerCommand observationManagerCommand) throws PersistenceException;
}
