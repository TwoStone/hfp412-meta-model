
package model.visitor;
import model.UserException;
import persistence.*;

public interface ObservationManagerCommandReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleCreateObservationCommand(PersistentCreateObservationCommand createObservationCommand) throws PersistenceException, E;
    public R handleDeleteObservationCommand(PersistentDeleteObservationCommand deleteObservationCommand) throws PersistenceException, E;
    
}
