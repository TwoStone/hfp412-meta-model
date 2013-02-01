
package model.visitor;
import model.UserException;
import persistence.*;

public interface NameSchemeManagerCommandExceptionVisitor<E extends UserException> {
    
    public void handleAssignTypeCommand(PersistentAssignTypeCommand assignTypeCommand) throws PersistenceException, E;
    public void handleAssignNameCommand(PersistentAssignNameCommand assignNameCommand) throws PersistenceException, E;
    public void handleCreateNameSchemeCommand(PersistentCreateNameSchemeCommand createNameSchemeCommand) throws PersistenceException, E;
    
}
