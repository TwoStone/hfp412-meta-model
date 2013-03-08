
package model.visitor;
import model.UserException;
import persistence.*;

public interface ObservationManagerCommandExceptionVisitor<E extends UserException> {
    
    public void handleCreateObservationCommand(PersistentCreateObservationCommand createObservationCommand) throws PersistenceException, E;
    public void handleDeleteObservationCommand(PersistentDeleteObservationCommand deleteObservationCommand) throws PersistenceException, E;
    
}
