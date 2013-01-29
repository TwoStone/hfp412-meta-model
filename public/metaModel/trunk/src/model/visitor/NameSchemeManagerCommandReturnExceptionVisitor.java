
package model.visitor;
import model.UserException;
import persistence.*;

public interface NameSchemeManagerCommandReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleCreateNameSchemeCommand(PersistentCreateNameSchemeCommand createNameSchemeCommand) throws PersistenceException, E;
    public R handleAssignNameSchemeCommand(PersistentAssignNameSchemeCommand assignNameSchemeCommand) throws PersistenceException, E;
    
}
