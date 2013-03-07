
package model.visitor;
import model.UserException;
import persistence.*;

public interface ObservationManagerCommandReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleCreateObsTypeCommand(PersistentCreateObsTypeCommand createObsTypeCommand) throws PersistenceException, E;
    public R handleDeleteObsTypeCommand(PersistentDeleteObsTypeCommand deleteObsTypeCommand) throws PersistenceException, E;
    public R handleCreateObservationCommand(PersistentCreateObservationCommand createObservationCommand) throws PersistenceException, E;
    public R handleDeleteObservationCommand(PersistentDeleteObservationCommand deleteObservationCommand) throws PersistenceException, E;
    
}
