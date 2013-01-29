
package model.visitor;
import model.UserException;
import persistence.*;

public interface NameSchemeManagerCommandReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleAssignTypeCommand(PersistentAssignTypeCommand assignTypeCommand) throws PersistenceException, E;
    public R handleAssignNameCommand(PersistentAssignNameCommand assignNameCommand) throws PersistenceException, E;
    public R handleCreateNameSchemeCommand(PersistentCreateNameSchemeCommand createNameSchemeCommand) throws PersistenceException, E;
    
}
