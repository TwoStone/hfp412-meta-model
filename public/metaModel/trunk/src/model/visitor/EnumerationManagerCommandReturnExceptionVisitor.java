
package model.visitor;
import model.UserException;
import persistence.PersistenceException;
import persistence.PersistentCreateEnumCommand;
import persistence.PersistentCreateEnumValueCommand;
import persistence.PersistentDeleteEnumCommand;
import persistence.PersistentDeleteEnumValueCommand;

public interface EnumerationManagerCommandReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleCreateEnumCommand(PersistentCreateEnumCommand createEnumCommand) throws PersistenceException, E;
    public R handleDeleteEnumCommand(PersistentDeleteEnumCommand deleteEnumCommand) throws PersistenceException, E;
    public R handleCreateEnumValueCommand(PersistentCreateEnumValueCommand createEnumValueCommand) throws PersistenceException, E;
    public R handleDeleteEnumValueCommand(PersistentDeleteEnumValueCommand deleteEnumValueCommand) throws PersistenceException, E;
    
}
