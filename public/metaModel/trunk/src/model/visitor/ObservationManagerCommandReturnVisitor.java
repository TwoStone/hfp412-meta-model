
package model.visitor;

import persistence.*;

public interface ObservationManagerCommandReturnVisitor<R> {
    
    public R handleCreateObsTypeCommand(PersistentCreateObsTypeCommand createObsTypeCommand) throws PersistenceException;
    public R handleDeleteObsTypeCommand(PersistentDeleteObsTypeCommand deleteObsTypeCommand) throws PersistenceException;
    public R handleCreateObservationCommand(PersistentCreateObservationCommand createObservationCommand) throws PersistenceException;
    public R handleDeleteObservationCommand(PersistentDeleteObservationCommand deleteObservationCommand) throws PersistenceException;
    
}
