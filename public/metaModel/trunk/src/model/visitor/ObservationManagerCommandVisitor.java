
package model.visitor;

import persistence.*;

public interface ObservationManagerCommandVisitor {
    
    public void handleCreateObservationCommand(PersistentCreateObservationCommand createObservationCommand) throws PersistenceException;
    public void handleDeleteObservationCommand(PersistentDeleteObservationCommand deleteObservationCommand) throws PersistenceException;
    
}
