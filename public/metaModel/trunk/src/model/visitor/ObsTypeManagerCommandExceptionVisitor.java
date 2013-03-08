
package model.visitor;
import model.UserException;
import persistence.*;

public interface ObsTypeManagerCommandExceptionVisitor<E extends UserException> {
    
    public void handleCreateObsTypeCommand(PersistentCreateObsTypeCommand createObsTypeCommand) throws PersistenceException, E;
    public void handleDeleteObsTypeCommand(PersistentDeleteObsTypeCommand deleteObsTypeCommand) throws PersistenceException, E;
    
}