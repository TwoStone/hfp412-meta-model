
package model.visitor;

import persistence.*;

public interface ObservationManagerCommandReturnVisitor<R> {
    
    public R handleCreateObservationCommand(PersistentCreateObservationCommand createObservationCommand) throws PersistenceException;
    public R handleDeleteObservationCommand(PersistentDeleteObservationCommand deleteObservationCommand) throws PersistenceException;
    
}
