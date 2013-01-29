
package model.visitor;
import model.UserException;
import persistence.*;

public interface NameSchemeInstaceManagerCommandReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleAssignNameCommand(PersistentAssignNameCommand assignNameCommand) throws PersistenceException, E;
    public R handleCreateInstanceCommand(PersistentCreateInstanceCommand createInstanceCommand) throws PersistenceException, E;
    
}
