
package model.visitor;
import model.UserException;
import persistence.*;

public interface NameSchemeInstaceManagerCommandExceptionVisitor<E extends UserException> {
    
    public void handleAssignNameCommand(PersistentAssignNameCommand assignNameCommand) throws PersistenceException, E;
    public void handleCreateInstanceCommand(PersistentCreateInstanceCommand createInstanceCommand) throws PersistenceException, E;
    
}
