
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentCreateObsTypeCommand;
import persistence.PersistentCreateObservationCommand;
import persistence.PersistentDeleteObsTypeCommand;
import persistence.PersistentDeleteObservationCommand;

public interface ObservationManagerCommandVisitor {
    
    public void handleCreateObsTypeCommand(PersistentCreateObsTypeCommand createObsTypeCommand) throws PersistenceException;
    public void handleDeleteObsTypeCommand(PersistentDeleteObsTypeCommand deleteObsTypeCommand) throws PersistenceException;
    public void handleCreateObservationCommand(PersistentCreateObservationCommand createObservationCommand) throws PersistenceException;
    public void handleDeleteObservationCommand(PersistentDeleteObservationCommand deleteObservationCommand) throws PersistenceException;
    
}
