
package model.visitor;
import model.UserException;
import persistence.PersistenceException;
import persistence.PersistentCreateObsTypeCommand;
import persistence.PersistentCreateObservationCommand;
import persistence.PersistentDeleteObsTypeCommand;
import persistence.PersistentDeleteObservationCommand;

public interface ObservationManagerCommandExceptionVisitor<E extends UserException> {
    
    public void handleCreateObsTypeCommand(PersistentCreateObsTypeCommand createObsTypeCommand) throws PersistenceException, E;
    public void handleDeleteObsTypeCommand(PersistentDeleteObsTypeCommand deleteObsTypeCommand) throws PersistenceException, E;
    public void handleCreateObservationCommand(PersistentCreateObservationCommand createObservationCommand) throws PersistenceException, E;
    public void handleDeleteObservationCommand(PersistentDeleteObservationCommand deleteObservationCommand) throws PersistenceException, E;
    
}
