
package model.visitor;
import model.UserException;
import persistence.*;

public interface EnumerationManagerCommandReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleCreateEnumCommand(PersistentCreateEnumCommand createEnumCommand) throws PersistenceException, E;
    public R handleDeleteEnumCommand(PersistentDeleteEnumCommand deleteEnumCommand) throws PersistenceException, E;
    
}
