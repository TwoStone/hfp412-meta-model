
package model.visitor;
import model.UserException;
import persistence.*;

public interface NameSchemeManagerCommandExceptionVisitor<E extends UserException> {
    
    public void handleCreateNameSchemeCommand(PersistentCreateNameSchemeCommand createNameSchemeCommand) throws PersistenceException, E;
    public void handleAssignNameSchemeCommand(PersistentAssignNameSchemeCommand assignNameSchemeCommand) throws PersistenceException, E;
    
}
