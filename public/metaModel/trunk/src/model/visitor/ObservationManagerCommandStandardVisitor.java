
package model.visitor;

import persistence.ObservationManagerCommand;
import persistence.PersistenceException;
import persistence.PersistentCreateObsTypeCommand;
import persistence.PersistentCreateObservationCommand;
import persistence.PersistentDeleteObsTypeCommand;
import persistence.PersistentDeleteObservationCommand;

public abstract class ObservationManagerCommandStandardVisitor implements ObservationManagerCommandVisitor {
    
    public void handleDeleteObservationCommand(PersistentDeleteObservationCommand deleteObservationCommand) throws PersistenceException{
        this.standardHandling(deleteObservationCommand);
    }
    public void handleCreateObservationCommand(PersistentCreateObservationCommand createObservationCommand) throws PersistenceException{
        this.standardHandling(createObservationCommand);
    }
    public void handleCreateObsTypeCommand(PersistentCreateObsTypeCommand createObsTypeCommand) throws PersistenceException{
        this.standardHandling(createObsTypeCommand);
    }
    public void handleDeleteObsTypeCommand(PersistentDeleteObsTypeCommand deleteObsTypeCommand) throws PersistenceException{
        this.standardHandling(deleteObsTypeCommand);
    }
    protected abstract void standardHandling(ObservationManagerCommand observationManagerCommand) throws PersistenceException;
}
